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

    Button btnHistorial;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     }

     //Metodo para pasar de un activity a otro
    public void eventoSiguiente(View view)
    {
        Intent siguiente = new Intent(this, PorLetras.class);
        startActivity(siguiente);
    }
    public void porPalabras(View view)
    {
        Intent palabras = new Intent(this, PorPalabras.class);
        startActivity(palabras);
    }

    public void historial(View view)
    {
        Intent historial = new Intent(this, HistorialResultados.class);
        startActivity(historial);
    }

}