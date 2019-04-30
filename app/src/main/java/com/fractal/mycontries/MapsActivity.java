package com.fractal.mycontries;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fractal.mycontries.Model.Country;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Country country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //pega ubs passada pela main
        country = (Country) getIntent().getSerializableExtra("country");

        //inicializa mapFragment
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        //coordenadas do pais
        String coordenada = country.latlng;
        String coordenadas[] = coordenada.split(",");
        LatLng countrylatlng = new LatLng(Double.parseDouble(coordenadas[0]), Double.parseDouble(coordenadas[1]));

        //adiciona marcador e move a camera do mapa para ele
        googleMap.addMarker(new MarkerOptions().position(countrylatlng).title(country.nome));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(countrylatlng, 12.0f));
    }
}
