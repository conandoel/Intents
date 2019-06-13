package com.example.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NUsuarioActivity extends AppCompatActivity {

    private Button buttonNuevo;
    private EditText editTextUsuario, editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nusuario);

        getSupportActionBar().hide();

        this.cargarComponentes();
    }

    private void cargarComponentes(){

        buttonNuevo=findViewById(R.id.buttonNuevo);
        editTextUsuario=findViewById(R.id.editTextUsuario);
        editTextPass=findViewById(R.id.editTextPass);

        buttonNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validarUsuario();

            }
        }
        );
    }

    private void validarUsuario(){
        String e=editTextUsuario.getText().toString();
        String p=editTextPass.getText().toString();

        if ((e != "") && (p != "")){

            Intent intent = new Intent(this, MainActivity.class);

            intent.putExtra("EXTRA_USUARIO", e);
            intent.putExtra("EXTRA_PASS", p);

            startActivity(intent);
            finish();

        }
        else{
            Toast.makeText(this, "Datos incorrectos, Reintente", Toast.LENGTH_SHORT).show();
        }
    }
}
