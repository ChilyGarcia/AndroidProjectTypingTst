package com.example.dedosrapidos_pruebadeescriturarpida;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private EditText et;

        Button btnLetras, btnPalabras, btnHistorial;



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