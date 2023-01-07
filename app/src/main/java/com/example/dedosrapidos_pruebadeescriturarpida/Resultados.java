package com.example.dedosrapidos_pruebadeescriturarpida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Resultados extends AppCompatActivity
{
    private TextView tvCorrectos, tvIncorrectos, tvPresicion, tvWPMCPM;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        tvCorrectos = (TextView) findViewById(R.id.infoCorrectas);
        tvIncorrectos = (TextView) findViewById(R.id.infoIncorrectas);
        tvPresicion = (TextView) findViewById(R.id.infoPresicion);
        tvWPMCPM = (TextView) findViewById(R.id.infoWpm);

        //Obtenemos las keys de lo que recibimos de la activity anterior
        String correctos = getIntent().getStringExtra("correctos");
        String incorrectos = getIntent().getStringExtra("incorrectos");
        String presicion = getIntent().getStringExtra("presicion");
        String cpm = getIntent().getStringExtra("wpmcpm");

        tvCorrectos.setText(correctos);
        tvIncorrectos.setText(incorrectos);
        tvPresicion.setText(presicion);
        tvWPMCPM.setText(cpm);

        

    }

    public void registro(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null,1);

        //Abrir base de datos para lectura y escritura
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        //Rescatar lo que contengan los TV
        String correctas = tvCorrectos.getText().toString();
        String incorrectos = tvIncorrectos.getText().toString();
        String presicion = tvPresicion.getText().toString();
        String cpmwpm = tvWPMCPM.getText().toString();

        ContentValues registro = new ContentValues();

        //Registro en la base de datos
        registro.put("correctas", correctas);
        registro.put("incorrectos", incorrectos);
        registro.put("presicion", presicion);
        registro.put("cpmwpm", cpmwpm);

        baseDatos.insert("Resultados",null,  registro);
        baseDatos.close();

        Toast.makeText(this, "Se ha registrado correctamente", Toast.LENGTH_SHORT).show();

    }

    //Llevar a inicio
    public void inicio(View view)
    {
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}