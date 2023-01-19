package com.example.dedosrapidos_pruebadeescriturarpida.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.dedosrapidos_pruebadeescriturarpida.entidad.ResultadosPruebas;

import java.util.ArrayList;

public class dbResultados extends AdminSQLiteOpenHelper{

    Context context;

    public dbResultados(@Nullable Context context) {
        super(context);
        this.context = context;
    }


    public void Registrar(String correctos, String incorrectos, String presicion, String wpmcpm)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context);
        //Abrir base de datos para lectura y escritura
        SQLiteDatabase baseDatos = admin.getWritableDatabase();


        if(!correctos.isEmpty() && !incorrectos.isEmpty() && !presicion.isEmpty() && !wpmcpm.isEmpty())
        {
            ContentValues registro = new ContentValues();

            registro.put("correctas", correctos);
            registro.put("incorrectas", incorrectos);
            registro.put("presicion", presicion);
            registro.put("cpmwpm", wpmcpm);

            baseDatos.insert("Resultados", null, registro);
            baseDatos.close();


        }
    }

    public ArrayList<ResultadosPruebas> mostrarContactos() {

        AdminSQLiteOpenHelper dbHelper = new AdminSQLiteOpenHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<ResultadosPruebas> listaContactos = new ArrayList<>();
        ResultadosPruebas contacto;
        Cursor cursorContactos;

        cursorContactos = db.rawQuery("SELECT * FROM Resultados", null);

        if (cursorContactos.moveToFirst()) {
            do {
                contacto = new ResultadosPruebas();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setCorrectos(cursorContactos.getString(1));
                contacto.setIncorrectos(cursorContactos.getString(2));
                contacto.setPrecision(cursorContactos.getString(3));
                contacto.setWpmcpm(cursorContactos.getString(4));

                listaContactos.add(contacto);
            } while (cursorContactos.moveToNext());
        }

        cursorContactos.close();

        return listaContactos;
    }


}
