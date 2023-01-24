package com.example.dedosrapidos_pruebadeescriturarpida;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;

public class PorLetras extends AppCompatActivity {
    //Variables para contador
    private static final long START_TIME_IN_MILLIS = 60000;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    private TextView tv, tvCorrectos, tvIncorrectos, tvPresicion, tvCPM, tvInfo;
    private EditText et;

    private int correctos = 0;
    private int incorrectos = 0;
    private int contador = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_por_letras);

        tv = (TextView) findViewById(R.id.campoPalabra);
        tvCorrectos = (TextView) findViewById(R.id.correctos);
        tvIncorrectos = (TextView) findViewById(R.id.incorrectos);
        tvPresicion = (TextView) findViewById(R.id.presicion);
        tvCPM = (TextView) findViewById(R.id.wpm);
        tvInfo = (TextView) findViewById(R.id.tvInfoContador);

        //Cuando inicia la prueba la primera letra que sale es random
        alimentar();

        et = (EditText) findViewById(R.id.textCampo);

        //Capturas lo que el usuario presione en el teclado del telefono}
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
                if(campo.isEmpty())
                {
                    tv.setTextColor(Color.BLACK);
                    tv.setTextSize(24);

                }
                else if(campo.charAt(0) == capture.charAt(0)) {
                    startTimer();
                    tv.setTextColor(Color.GREEN);
                    tv.setTextSize(28);
                }
                else if(campo.charAt(0) != campo.charAt(0))
                {
                    tv.setTextColor(Color.RED);
                    tv.setTextSize(28);
                }
                else
                {
                    tv.setTextColor(Color.RED);
                    tv.setTextSize(28);
                }

                for(int in = 0; in < palabra.length(); in++) {

                    if (Character.isSpace(et.getText().toString().charAt(in))) {
                        contador++;

                        //Se valida que lo que esté dentro del editText corresponda a lo que esta en el textView
                        if(campo.equals(capture))
                        {
                            Toast.makeText(PorLetras.this, "Es correcto", Toast.LENGTH_SHORT).show();
                            correctos++;

                            String correctosParse = String.valueOf(correctos);
                            tvCorrectos.setText(correctosParse);
                            tv.setTextSize(24);
                            alimentar();
                            et.setText("");

                        }
                        else
                        {
                            Toast.makeText(PorLetras.this, "Es incorrecto", Toast.LENGTH_SHORT).show();
                            incorrectos++;
                            String incorrectosParse = String.valueOf(incorrectos);
                            tvIncorrectos.setText(incorrectosParse);
                            tv.setTextSize(24);
                            alimentar();
                            et.setText("");

                        }
                        //Suma de correctos e incorrectos para hallar el CPM
                        int sumaCorrectosEIncorrectos = 0;
                        sumaCorrectosEIncorrectos = correctos + incorrectos;
                        String mostrarCpm = String.valueOf(sumaCorrectosEIncorrectos);

                        tvCPM.setText(mostrarCpm);

                        //DecimalFormat para limitar la cantidad de decimales que hay en el float
                        DecimalFormat df = new DecimalFormat("#.00");
                        float dividido = contador /100f;
                        float porcentaje = correctos / dividido;
                        String contadorFloatParse = String.valueOf(df.format(porcentaje));

                        tvPresicion.setText(contadorFloatParse);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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
                resultados();

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

    //Metodo para alimentar el textView con las palabras que esten almacenadas en el Vector
    public void alimentar() {

        String lista[] = {"a ", "b ", "c ", "d ", "e ", "f ", "g ", "h ", "i ", "j ", "k ", "l ", "m ", "n ", "o ", "p ", "q ", "r ", "s ", "t ", "u ",
                "v ", "w ", "x ", "y ", "z ", "A ", "B ", "C ", "D ", "E ", "F ", "G ", "H ", "I ", "J ", "K ", "L ", "M ", "N ", "O ", "P ", "Q ", "R ", "S ",
                "T ", "U ", "V ", "W ", "X ", "Y ", "Z "};
        int numero = (int) (Math.random() * 52);
        String finalLetra = lista[numero];
        tv.setText(finalLetra);

    }
    public void resultados()
    {
        Intent resultados = new Intent(this, Resultados.class);

        //Paso de parametros hacia la otra activity
        resultados.putExtra("correctos", tvCorrectos.getText().toString());
        resultados.putExtra("incorrectos", tvIncorrectos.getText().toString());
        resultados.putExtra("presicion", tvPresicion.getText().toString());
        resultados.putExtra("wpmcpm", tvCPM.getText().toString());
        resultados.putExtra("tipoPrueba", "CPM");


        startActivity(resultados);
    }
}