package com.example.dedosrapidos_pruebadeescriturarpida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadosDetalles extends AppCompatActivity {

    TextView tvDetallesCorrectas, tvDetallesIncorrectas, tvDetallesPrecision, tvDetalleWpm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_detalles);

        tvDetallesCorrectas = (TextView) findViewById(R.id.tvDetallesCorrectas);
        tvDetallesIncorrectas = (TextView) findViewById(R.id.tvDetallesIncorrectas);
        tvDetallesPrecision = (TextView) findViewById(R.id.tvDetallesPrecision);
        tvDetalleWpm = (TextView) findViewById(R.id.tvDetalleWpm);


        String correctas = getIntent().getStringExtra("correctas");
        String incorrectas = getIntent().getStringExtra("incorrectas");
        String precision = getIntent().getStringExtra("precision");
        String wpm = getIntent().getStringExtra("wpmcpm");

        tvDetallesCorrectas.setText(correctas);
        tvDetallesIncorrectas.setText(incorrectas);
        tvDetallesPrecision.setText(precision);
        tvDetalleWpm.setText(wpm);

    }
}