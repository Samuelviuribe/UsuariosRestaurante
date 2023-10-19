package com.example.cuestionariorestaurantes.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;


public class Usuarios extends helper {
    Context context;
    public Usuarios(@Nullable Context context) {
        super(context);
        this.context = context;

    }
    public long insertausuario(String nombre, String correo_electronico, String contraseña,String telefono){

        long id= 0;

        try {
            helper Dbhelper = new helper(context);
            SQLiteDatabase db = Dbhelper.getWritableDatabase();

            ContentValues Values = new ContentValues();

            Values.put("Nombre", nombre);
            Values.put("correo_electronico", correo_electronico);
            Values.put("contraseña", contraseña);
            Values.put("telefono", telefono);

            id = db.insert(TABLE_USUARIOS, null, Values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;

    }
}
