package com.example.dedosrapidos_pruebadeescriturarpida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HistorialResultados extends AppCompatActivity
{

    ListView listViewContacto;
    List<ResultadosPruebas> lst;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_resultados);

        listViewContacto = findViewById(R.id.listViewContacto);

        CustomAdapter adapter = new CustomAdapter(this, getData());
        listViewContacto.setAdapter(adapter);

        //Accion de eleccion de listView
        listViewContacto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ResultadosPruebas r = lst.get(i);
                Toast.makeText(getBaseContext(), r.nombre, Toast.LENGTH_SHORT).show();
            }
        });



    }

    private List<ResultadosPruebas> getData()
    {
        lst = new ArrayList<>();

        lst.add(new ResultadosPruebas(1, R.drawable.compartir, "Juan", "321323123"));
        lst.add(new ResultadosPruebas(2, R.drawable.compartir, "Esteban", "321323123"));
        lst.add(new ResultadosPruebas(3, R.drawable.compartir, "Lamara", "321323123"));

        return lst;

    }
}