package com.example.dedosrapidos_pruebadeescriturarpida;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dedosrapidos_pruebadeescriturarpida.adaptadores.ListaContactosAdapter;
import com.example.dedosrapidos_pruebadeescriturarpida.db.dbResultados;
import com.example.dedosrapidos_pruebadeescriturarpida.entidad.ResultadosPruebas;

import java.util.ArrayList;

public class HistorialResultados extends AppCompatActivity {

    RecyclerView listaResultados;
    ArrayList<ResultadosPruebas> listaArrayResultadosPruebas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_resultados);

        listaResultados = findViewById(R.id.listaContactos);
        listaResultados.setLayoutManager(new LinearLayoutManager(this));

        dbResultados dbResultados = new dbResultados(HistorialResultados.this);

        listaArrayResultadosPruebas = new ArrayList<>();

        String tipoPrueba = getIntent().getStringExtra("tipoPrueba");

        //Se le envia al adaptador
        ListaContactosAdapter adapter = new ListaContactosAdapter(dbResultados.mostrarContactos(), tipoPrueba);

        listaResultados.setAdapter(adapter);


    }
}