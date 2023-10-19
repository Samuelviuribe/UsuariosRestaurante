package com.example.cuestionariorestaurantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cuestionariorestaurantes.db.Usuarios;

public class RegistroUsuarios extends AppCompatActivity {

        EditText TxtNombre,TxtCorreo,TxtContraseña,TxtTelefono;
        Button botonregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        TxtNombre = findViewById(R.id.editTextText3);//si me dio pereza hacer el string y luego sufri haciendolo así xD
        TxtCorreo = findViewById(R.id.editTextText4);
        TxtTelefono = findViewById(R.id.editTextText5);
        TxtContraseña = findViewById(R.id.editTextText6);
        botonregis = findViewById(R.id.button3);

        botonregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuarios usuarios = new Usuarios(RegistroUsuarios.this);
                long id = usuarios.insertausuario(TxtNombre.getText().toString(),TxtCorreo.getText().toString(),TxtContraseña.getText().toString(),TxtTelefono.getText().toString());


                if (id>0){

                    Toast.makeText(RegistroUsuarios.this,"Registro Guardado",Toast.LENGTH_LONG).show();
                    limpiar();
                }  else{
                    Toast.makeText(RegistroUsuarios.this,"Error Al guardar registro",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private void limpiar(){
        TxtNombre.setText("");
        TxtCorreo.setText("");
        TxtContraseña.setText("");
        TxtTelefono.setText("");
}
}