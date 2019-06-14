package com.example.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CondicionesActivity extends AppCompatActivity {

    private CheckBox checkBoxCondicion;
    private Button buttonAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condiciones);
        getSupportActionBar().hide();

        this.cargarComponentes();
    }

    private void cargarComponentes(){

        checkBoxCondicion = findViewById(R.id.checkBoxCondicion);
        buttonAceptar = findViewById(R.id.buttonAceptar);

        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aNuevoUsuario();
            }
        });

    }

    private void aNuevoUsuario(){

        if (checkBoxCondicion.isChecked()){

            Intent i = new Intent(this, NUsuarioActivity.class);
            startActivity(i);

        }
        else{
            Toast.makeText(this, "Debe aceptar las condiciones", Toast.LENGTH_SHORT).show();
        }

    }
}
