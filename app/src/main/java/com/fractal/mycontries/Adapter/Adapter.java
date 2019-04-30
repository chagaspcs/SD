package com.fractal.mycontries.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.fractal.mycontries.Model.Country;
import com.fractal.mycontries.R;

public class Adapter extends ArrayAdapter<Country> {

public Adapter(Context context, List<Country> objects) {
        super(context, 0, objects);
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        Country country = getItem(position);
        if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_country, parent, false);
        }

        TextView tvNome = (TextView) convertView.findViewById(R.id.nome);
        TextView tvCapital = (TextView) convertView.findViewById(R.id.capital);

        tvNome.setText(country.nome);
        tvCapital.setText(country.capital);

        return convertView;
        }

        }