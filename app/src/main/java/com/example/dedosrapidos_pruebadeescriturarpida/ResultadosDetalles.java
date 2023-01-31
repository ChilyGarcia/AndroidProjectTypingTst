package com.example.dedosrapidos_pruebadeescriturarpida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadosDetalles extends AppCompatActivity {

    TextView tvDetallesCorrectas, tvDetallesIncorrectas, tvDetallesPrecision, tvDetalleWpm, detalleWpmCpm;
    Button btnHome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_detalles);

        tvDetallesCorrectas = (TextView) findViewById(R.id.tvDetallesCorrectas);
        tvDetallesIncorrectas = (TextView) findViewById(R.id.tvDetallesIncorrectas);
        tvDetallesPrecision = (TextView) findViewById(R.id.tvDetallesPrecision);
        tvDetalleWpm = (TextView) findViewById(R.id.tvDetalleWpm);
        detalleWpmCpm = (TextView) findViewById(R.id.detalleWpmCpm);

        btnHome = findViewById(R.id.btnHome);


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }
        });


        String correctas = getIntent().getStringExtra("correctas");
        String incorrectas = getIntent().getStringExtra("incorrectas");
        String precision = getIntent().getStringExtra("precision");
        String wpm = getIntent().getStringExtra("wpmcpm");
        String tipoPrueba = getIntent().getStringExtra("tipoPrueba");

        tvDetallesCorrectas.setText(correctas);
        tvDetallesIncorrectas.setText(incorrectas);
        tvDetallesPrecision.setText(precision);
        tvDetalleWpm.setText(wpm);
        detalleWpmCpm.setText(tipoPrueba);

        getSupportActionBar().hide();

    }

    public void Home()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}