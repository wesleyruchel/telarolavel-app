package com.example.telarolavel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EntradaAdapter extends BaseAdapter {

    List<Entrada> entradas;
    LayoutInflater inflator;

    public EntradaAdapter(List<Entrada> entradas, Context ctx) {
        this.entradas = entradas;
        this.inflator = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return entradas.size();
    }

    @Override
    public Object getItem(int position) {
        return entradas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflator.inflate(R.layout.entrada_item, null);
        TextView txtSaida = (TextView) v.findViewById(R.id.txtSaida);
        txtSaida.setText(entradas.get(position).getConteudo());
        return v;
    }
}
