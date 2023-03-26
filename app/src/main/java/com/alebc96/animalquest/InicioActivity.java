package com.alebc96.animalquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class InicioActivity extends AppCompatActivity {

    private Button iniciar;
    private Button respuestas;

    private Button acercade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        iniciar = findViewById(R.id.inicio);
        respuestas = findViewById(R.id.respuesta);
        acercade = findViewById(R.id.acercade);

        iniciar.setOnClickListener(view -> {
            Intent page1 = new Intent(InicioActivity.this, GameActivity.class);
            startActivity(page1);
        });

        respuestas.setOnClickListener(view -> {
            Intent page2 = new Intent(InicioActivity.this, LastActivity.class);
            startActivity(page2);
        });

        acercade.setOnClickListener(view -> {
            Intent page3 = new Intent(InicioActivity.this, AcercaActivity.class);
            startActivity(page3);
        });
    }
}