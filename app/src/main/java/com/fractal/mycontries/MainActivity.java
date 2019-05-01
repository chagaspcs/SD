package com.fractal.mycontries;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
//import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fractal.mycontries.Adapter.Adapter;
import com.fractal.mycontries.Model.Country;
import com.fractal.mycontries.dao.Repositorio;
import com.fractal.mycontries.util.HttpRetro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private Adapter adapter;
    private List<Country> countryList;
    private ListView listView;
    private SwipeRefreshLayout swiperefresh;
    Repositorio db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swiperefresh = (SwipeRefreshLayout) findViewById((R.id.swiperefresh));
        //seta cores
        swiperefresh.setColorScheme(R.color.colorPrimary, R.color.colorAccent);
        swiperefresh.setOnRefreshListener(this);

        listView = (ListView) findViewById(R.id.listView);

        countryList = new ArrayList<Country>();

        adapter = new Adapter(this, countryList);

        db = new Repositorio(getBaseContext());

        getDataRetro();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                hasPermission();

                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("country",countryList.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRefresh() {
        getDataRetro();

    }

    public void getDataRetro() {

        swiperefresh.setRefreshing(true);

        // se tiver conexao faz get, senao pega do sqlite
        if (isConnected()) {
            HttpRetro.getCountryClient().getCountry().enqueue(new Callback<List<Country>>() {
                public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                    if (response.isSuccessful()) {
                        List<Country> countryBody = response.body();
                        countryList.clear();

                        db.excluirAll();

                        for (Country country : countryBody) {
                            countryList.add(country);
                            db.inserir(country);
                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        System.out.println(response.errorBody());
                    }
                    swiperefresh.setRefreshing(false);
                }

                @Override
                public void onFailure(Call<List<Country>> call, Throwable t) {
                    t.printStackTrace();
                }

            });

        }else {
            swiperefresh.setRefreshing(false);
            Toast.makeText(this,"Sem Conexão, listando Países do banco...",Toast.LENGTH_SHORT).show();
            getDataSqlite();
        }

    }

    public Boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( cm != null ) {
            NetworkInfo ni = cm.getActiveNetworkInfo();
            return ni != null && ni.isConnected();
        }
        return false;
    }

    private void getDataSqlite() {
        countryList.clear();
        countryList.addAll(db.listarCountry());
        adapter.notifyDataSetChanged();
    }

    void hasPermission(){
        //pede permissao de localizacao
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // ja pediu permissao?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {

                // solicita permissao de localizacao
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            }
        }
    }

}

