package com.example.cuestionariorestaurantes.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.cuestionariorestaurantes.entities.Registros;

import java.util.ArrayList;


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

    public  ArrayList<Registros> mostrarRegistros(){

        helper Dbhelper = new helper(context);
        SQLiteDatabase db = Dbhelper.getWritableDatabase();

        ArrayList<Registros> ListaRegristros = new ArrayList<>();
        Registros Registro = null;
        Cursor cursorRegistro = null;
        cursorRegistro = db.rawQuery("SELECT * FROM "+TABLE_USUARIOS,null);

        if (cursorRegistro.moveToFirst()){
            do {

                Registro = new Registros();
                Registro.setNombre(cursorRegistro.getString(1));
                Registro.setCorreo(cursorRegistro.getString(2));
                Registro.setContraseña(cursorRegistro.getString(3));
                Registro.setTelefono(cursorRegistro.getString(4));
                ListaRegristros.add(Registro);
            }while (cursorRegistro.moveToNext());

        }
        cursorRegistro.close();
        return ListaRegristros;
    }

    public  Registros verRegistros(int telefono){

        helper Dbhelper = new helper(context);
        SQLiteDatabase db = Dbhelper.getWritableDatabase();


        Registros Registro = null;
        Cursor cursorRegistro = null;
        cursorRegistro = db.rawQuery("SELECT * FROM "+TABLE_USUARIOS+"WHERE telefono ="+telefono+"LIMIT 1",null);

        if (cursorRegistro.moveToFirst()){


                Registro = new Registros();
                Registro.setNombre(cursorRegistro.getString(1));
                Registro.setCorreo(cursorRegistro.getString(2));
                Registro.setContraseña(cursorRegistro.getString(3));
                Registro.setTelefono(cursorRegistro.getString(4));


        }
        cursorRegistro.close();
        return Registro;
    }

}
