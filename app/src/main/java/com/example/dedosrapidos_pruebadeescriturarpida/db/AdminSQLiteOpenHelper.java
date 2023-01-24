package com.example.dedosrapidos_pruebadeescriturarpida.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper
{
    public AdminSQLiteOpenHelper(@Nullable Context context) {
        super(context, "resultados.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDatos) {
        baseDatos.execSQL("CREATE TABLE Resultados(id INTEGER PRIMARY KEY AUTOINCREMENT, correctas TEXT, incorrectas TEXT, presicion TEXT, cpmwpm TEXT, tipoPrueba TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
