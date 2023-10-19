package com.example.cuestionariorestaurantes.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class helper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION= 1;
    private static final String DATABASE_NOMBRE="Restaurante.db";
    public static final String TABLE_USUARIOS="t_usuarios";
    public helper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE,null,DATABASE_VERSION  );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_USUARIOS+"(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL, " +
                "correo_electronico TEXT NOT NULL," +
                "contraseña TEXT NOT NULL," +
                "telefono TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_USUARIOS);
        onCreate(sqLiteDatabase);
    }
}
