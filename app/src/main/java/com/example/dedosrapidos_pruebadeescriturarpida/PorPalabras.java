package com.example.dedosrapidos_pruebadeescriturarpida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class PorPalabras extends AppCompatActivity {
    //Variables para contador
    private static final long START_TIME_IN_MILLIS = 60000;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    private TextView tv, tvPalabrasCorrectas, tvPalabrasIncorrectas, tvPresicion, tvWPM, tvLista, tvInfo;
    private EditText et;
    private int correctos = 0;
    private int incorrectos = 0;
    private int contador = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_por_palabras);

        tv = (TextView) findViewById(R.id.tvPalabra);
        tvPalabrasCorrectas = (TextView) findViewById(R.id.correctos);
        tvPalabrasIncorrectas = (TextView) findViewById(R.id.incorrectos);
        tvPresicion = (TextView) findViewById(R.id.presicion);
        tvWPM = (TextView) findViewById(R.id.wpm);
        tvLista = (TextView)findViewById(R.id.tvLista);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        et = (EditText) findViewById(R.id.campoPalabraEsccribir);

        alimentar();

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String capture = tv.getText().toString();
                String campo = et.getText().toString();
                String palabra = et.getText().toString();

                //Condocionales para cambiar el color de el textView si el usuario esta digitando bien o mal


                for(int in = 0; in < palabra.length(); in++) {

                    if (Character.isSpace(et.getText().toString().charAt(in))) {
                        contador++;

                        //Se valida que lo que esté dentro del editText corresponda a lo que esta en el textView
                        if(campo.equals(capture))
                        {
                            startTimer();
                            Toast.makeText(PorPalabras.this, "Es correcto", Toast.LENGTH_SHORT).show();
                            correctos++;
                            String historial = tvLista.getText().toString();
                            tvLista.setText(historial + campo);

                            String correctosParseo = String.valueOf(correctos);
                            tvPalabrasCorrectas.setText(correctosParseo);
                            tv.setTextSize(24);
                            alimentar();
                            et.setText("");

                        }
                        else
                        {
                            Toast.makeText(PorPalabras.this, "Es incorrecto", Toast.LENGTH_SHORT).show();
                            incorrectos++;
                            String incorrectosParse = String.valueOf(incorrectos);
                            tvPalabrasIncorrectas.setText(incorrectosParse);
                            tv.setTextSize(24);
                            alimentar();
                            et.setText("");

                        }
                        //Calculo del WPM
                        int calculoWPM = (correctos + incorrectos / 1) - incorrectos;
                        String mostrarWPM = String.valueOf(calculoWPM);
                        tvWPM.setText(mostrarWPM);

                        float dividido = contador /100f;
                        float contadorFloat = contador;
                        float porcentaje = correctos / dividido;
                        String contadorFloatParse = String.valueOf(porcentaje);
                        tvPresicion.setText(contadorFloatParse);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        getSupportActionBar().hide();

    }
    //Metodo para iniciar el contador del temporizador
    private void startTimer()
    {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillis = l;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                Resultados();

            }
        }.start();

        mTimerRunning = true;


    }
    private void updateCountDownText()
    {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormated = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        tvInfo.setText(timeLeftFormated);

    }

    public void alimentar() {
        String lista[] = {"de ", "la ", "sobre ", "este ", "ya ", "cuando ", "como ", "los ", "las ", "abierto ", "cerrado ",
                "parece ", "haber ", "bajo ", "nuestra ", "nuestro ", "nuestros ", "posible ", "tarde ", "importante ", "sentido",
                "guerra ", "cambio ", "mano ", "estar ", "padre ", "gente ", "final ", "incluso ", "madre ", "padre ", "mis "
        };
        int numero = (int) (Math.random() * 32);
        String finalLetra = lista[numero];
        tv.setText(finalLetra);

    }

    public void Resultados()
    {
        Intent intent = new Intent(this, Resultados.class);

        intent.putExtra("correctos", tvPalabrasCorrectas.getText().toString());
        intent.putExtra("incorrectos", tvPalabrasIncorrectas.getText().toString());
        intent.putExtra("presicion", tvPresicion.getText().toString());
        intent.putExtra("wpmcpm", tvWPM.getText().toString());
        intent.putExtra("tipoPrueba", "WPM");

        startActivity(intent);

    }
}