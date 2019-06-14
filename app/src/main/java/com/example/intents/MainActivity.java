package com.example.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button botonIngresar, buttonNU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        this.cargarComponentes();
    }


    private void cargarComponentes() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        botonIngresar = findViewById(R.id.botonIngresar);
        buttonNU=findViewById(R.id.buttonNU);

        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarUsuario();
            }
        });

        buttonNU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acondiciones();
            }
        });
    }

    private void acondiciones(){
        Intent i = new Intent(this, CondicionesActivity.class);
        startActivity(i);
    }

    private void validarUsuario(){
        String e=editTextEmail.getText().toString();
        String p=editTextPassword.getText().toString();

        if (e.equals("ites") && p.equals("1234")){

            Intent intent = new Intent(this, HomeActivity.class);

            intent.putExtra("EXTRA_EMAIL", e);

            startActivity(intent);
            finish();

        }
        else{
            Toast.makeText(this, "Datos incorrectos, Reintente", Toast.LENGTH_SHORT).show();
        }
    }

}
