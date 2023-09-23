package com.example.telarolavel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InicialActivity extends AppCompatActivity {
    TextView txtEntrada;
    List<Entrada> entradas = new ArrayList<>();
    ListView listEntradas;

    EntradaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        txtEntrada = (TextView) findViewById(R.id.txtEntrada);
        listEntradas = (ListView) findViewById(R.id.listEntradas);
        adapter = new EntradaAdapter(entradas, getBaseContext());
        listEntradas.setAdapter(adapter);

        listEntradas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("EVT", "POS: " + position + " ID: " + id);
                entradas.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void processarEntrada(View v) {
        Log.d("EVT", "btAddClick!");
        String entrada = txtEntrada.getText().toString();
        if (entrada.length() > 0) {
            Entrada e = new Entrada();
            e.setConteudo(entrada);
            entradas.add(e);
            txtEntrada.setText("");
            Log.d("EVT", "CT Entradas: " + entradas.size());
            adapter.notifyDataSetChanged();
        }
    }
}