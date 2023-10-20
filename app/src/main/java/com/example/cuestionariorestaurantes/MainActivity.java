package com.example.cuestionariorestaurantes;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuestionariorestaurantes.adaptadores.ListaUsuariosAdapter;
import com.example.cuestionariorestaurantes.db.Usuarios;
import com.example.cuestionariorestaurantes.db.helper;
import com.example.cuestionariorestaurantes.entities.Registros;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        RecyclerView ListaUsuarios;
        ArrayList<Registros> ListaArrayRegistros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaUsuarios = findViewById(R.id.listaReg);
        ListaUsuarios.setLayoutManager(new LinearLayoutManager(this));
        Button btnRegistrar = findViewById(R.id.btnregistrar);



        Usuarios dbUsuario = new Usuarios(MainActivity.this);
        ListaArrayRegistros = new ArrayList<>();

        ListaUsuariosAdapter adapter = new ListaUsuariosAdapter(dbUsuario.mostrarRegistros());
        ListaUsuarios.setAdapter(adapter);
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
