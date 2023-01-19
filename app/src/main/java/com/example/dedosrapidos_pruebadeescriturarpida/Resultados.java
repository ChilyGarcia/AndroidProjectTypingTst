package com.example.dedosrapidos_pruebadeescriturarpida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dedosrapidos_pruebadeescriturarpida.db.AdminSQLiteOpenHelper;
import com.example.dedosrapidos_pruebadeescriturarpida.db.dbResultados;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity
{
    private TextView tvCorrectos, tvIncorrectos, tvPresicion, tvWPMCPM;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        tvCorrectos = (TextView) findViewById(R.id.infoCorrectas);
        tvIncorrectos = (TextView) findViewById(R.id.infoIncorrectas);
        tvPresicion = (TextView) findViewById(R.id.infoPresicion);
        tvWPMCPM = (TextView) findViewById(R.id.infoWpm);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);




        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String correctos = tvCorrectos.getText().toString();
                String incorrectos = tvIncorrectos.getText().toString();
                String presicion = tvPresicion.getText().toString();
                String wpmcpm = tvWPMCPM.getText().toString();

                dbResultados db = new dbResultados(Resultados.this);
                db.Registrar(correctos, incorrectos, presicion, wpmcpm);


            }
        });


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


    //Llevar a inicio
    public void inicio(View view)
    {
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }

/*

    public void Registrar()
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        //Abrir base de datos para lectura y escritura
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        String correctos = tvCorrectos.getText().toString();
        String incorrectos = tvIncorrectos.getText().toString();
        String presicion = tvPresicion.getText().toString();
        String wpmCpm = tvWPMCPM.getText().toString();

;

        if(!correctos.isEmpty() && !incorrectos.isEmpty() && !presicion.isEmpty() && !wpmCpm.isEmpty())
        {
            ContentValues registro = new ContentValues();

            registro.put("correctas", correctos);
            registro.put("incorrectas", incorrectos);
            registro.put("presicion", presicion);
            registro.put("cpmwpm", wpmCpm);

            baseDatos.insert("Resultados", null, registro);
            baseDatos.close();

            Toast.makeText(this, "El registro se ha hecho correctamente", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Debe de ingresar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }



 */


    /*
    public ArrayList<ResultadosPruebas> listaResultadosPruebas()
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        ArrayList<ResultadosPruebas> listaResultadosPruebas = new ArrayList<>();
        ResultadosPruebas resultadosPruebas = null;
        Cursor cursorResultados = null;

        cursorResultados = baseDatos.rawQuery("SELECT * FROM Resultados", null);

        //Pasar el cursor al primer elemento que nos traiga de la consulta
        if(cursorResultados.moveToFirst())
        {
            do {
                resultadosPruebas = new ResultadosPruebas();
                //Obtener lo que hay en la primera columna de la consulta
                resultadosPruebas.setId(cursorResultados.getInt(0));
                resultadosPruebas.setCorrectos(cursorResultados.getString(1));
                resultadosPruebas.setIncorrectos(cursorResultados.getString(2));
                resultadosPruebas.setPrecision(cursorResultados.getString(3));
                resultadosPruebas.setWpmcpm(cursorResultados.getString(4));

                //Se añade el objeto que se acabo de alimentar a un espacio en la lista de objetos
                listaResultadosPruebas.add(resultadosPruebas);

            //Nos envia hasta el siguiente registro y asi hasta terminar
            }while(cursorResultados.moveToNext());

        }

        cursorResultados.close();

        return listaResultadosPruebas;
    }

     */


}