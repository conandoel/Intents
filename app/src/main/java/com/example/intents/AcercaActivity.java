package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcercaActivity extends AppCompatActivity {

    private Button buttonAcerca, buttonContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        getSupportActionBar().hide();

        this.cargarComponentes();
    }

    private void cargarComponentes(){

        buttonAcerca=findViewById(R.id.buttonAcerca);
        buttonContacto=findViewById(R.id.buttonContacto);

        buttonAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarWeb();
            }
        });

        buttonContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarTelefono();
            }
        });
    }

    private void lanzarWeb(){
        String url = "http ://www.deportecapital.com.ar";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }

    private void lanzarTelefono(){
        String tel = "+5492954667620";
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://"+tel));
        startActivity(i);
    }
}
