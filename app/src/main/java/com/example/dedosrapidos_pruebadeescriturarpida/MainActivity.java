package com.example.dedosrapidos_pruebadeescriturarpida;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private EditText et;
    Button btnLetras, btnPalabras, btnHistorial;
    private String url = "https://play.google.com/store/apps/details?id=me.pou.app&hl=es_419&gl=US";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLetras = (Button) findViewById(R.id.btnLetras);
        btnPalabras = (Button) findViewById(R.id.btnPalabras);
        btnHistorial = (Button) findViewById(R.id.btnHistorial);



        btnLetras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                porLetras();

            }
        });

        btnPalabras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                porPalabras();
            }
        });

        btnHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historial();
            }
        });







     }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.overflow, menu);
        //Cada quee se presione la tecla del menu se abrira correctamente
        return true;
    }

    //Metodo para agregar acciones a las opciones del menuItem
    //El nombre de este metodo tiene que ser el mismo para que funcione la aplicacion
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //Parar recuperar que opcion del menu ha sido seleccionada
        int id = item.getItemId();

        if(id == R.id.item1)
        {
            Uri link = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, link);
            startActivity(intent);


        }
        else if (id == R.id.item2)
        {
            Toast.makeText(this, "Se ha seleccionado el item numero 2", Toast.LENGTH_SHORT).show();

        }
        else if(id == R.id.item3)
        {
            Toast.makeText(this, "Se ha seleccionado el item numero 3", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);

    }

     //Metodo para pasar de un activity a otro
    public void porLetras()
    {
        Intent siguiente = new Intent(this, PorLetras.class);
        startActivity(siguiente);
    }
    public void porPalabras()
    {
        Intent palabras = new Intent(this, PorPalabras.class);
        startActivity(palabras);
    }

    public void historial()
    {
        Intent historial = new Intent(this, HistorialResultados.class);
        startActivity(historial);
    }

}