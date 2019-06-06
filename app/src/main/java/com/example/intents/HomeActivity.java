package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

   // private EditText editTextUrl, editTextTelefono;
    private Button buttonNavegar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String email=bundle.getString("EXTRA_EMAIL");

        setTitle("Bienvenido "+email);

        this.cargarComponentes();

    }
    //Crea el Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options_mainactivity, menu);

        return super.onCreateOptionsMenu(menu);
    }
    //Opciones del Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_acerca:
                levantarAcercade();
                return true;
            case R.id.action_salir:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
    //Acciones de las opciones del Menu
    private void levantarAcercade() {
        Intent i = new Intent(HomeActivity.this, AcercaActivity.class);
        startActivity(i);
    }

    private void cargarComponentes() {

       // editTextUrl = findViewById(R.id.editTextUrl);
        //editTextTelefono = findViewById(R.id.editTextTelefono);

        buttonNavegar = findViewById(R.id.buttonNavegar);
        //buttonSms = findViewById(R.id.buttonSms);
        //buttonLlamar = findViewById(R.id.buttonLlamar);


        buttonNavegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarWeb();
            }
        });


    }


    private void lanzarWeb(){
        String url = "https://www.archlinux.org";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }

}
