package com.example.cuestionariorestaurantes;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cuestionariorestaurantes.db.helper;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegistrar = findViewById(R.id.btnregistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // Crear una intención para abrir la actividad de registro de usuarios
                Intent intent = new Intent(MainActivity.this, RegistroUsuarios.class);
                startActivity(intent);

                helper dbHelper = new helper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db!=null){
                    Toast.makeText(MainActivity.this, "Proceso de creacion de usuario", Toast.LENGTH_SHORT).show();
                    //BASE DE DATOS CREADA
                }else{
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR LA DE DATOS", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
