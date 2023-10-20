package com.example.cuestionariorestaurantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cuestionariorestaurantes.db.Usuarios;
import com.example.cuestionariorestaurantes.entities.Registros;

public class VerActivity extends AppCompatActivity {
    EditText txtNombre, txtTelefono,txtCorreo, txtContraseña;
    Button btnguarda;

    Registros registro;
    int telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        txtTelefono = findViewById(R.id.editTextText5);//si
        txtNombre = findViewById(R.id.editTextText3);
        txtCorreo = findViewById(R.id.editTextText4);
        txtContraseña = findViewById(R.id.editTextText6);
        btnguarda = findViewById(R.id.button3);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                telefono = Integer.parseInt(null);
            } else {
                telefono = extras.getInt("telefono");
            }
        } else {
            telefono = (int) savedInstanceState.getSerializable("telefono");

        }
        Usuarios Usuario = new Usuarios(VerActivity.this);
        registro = Usuario.verRegistros(telefono);

        if (registro != null) {
            txtNombre.setText(registro.getNombre());
            txtContraseña.setText(registro.getContraseña());
            txtCorreo.setText(registro.getCorreo());
            txtTelefono.setText(registro.getTelefono());

            btnguarda.setVisibility(View.INVISIBLE);

            txtNombre.setInputType(InputType.TYPE_NULL);
            txtTelefono.setInputType(InputType.TYPE_NULL);
            txtCorreo.setInputType(InputType.TYPE_NULL);
            txtContraseña.setInputType(InputType.TYPE_NULL);
        }
    }
    }