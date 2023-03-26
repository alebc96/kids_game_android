package com.alebc96.animalquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResponseActivity extends AppCompatActivity {

    public TextView text_puntos;
    private SharedPreferences sharedPreferences;
    private ImageView img_response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        sharedPreferences = getSharedPreferences("Preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        text_puntos = findViewById(R.id.textResponse);
        img_response = findViewById(R.id.imageViewResponse);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            int puntos = extras.getInt("puntos", 0); // El segundo parámetro es el valor predeterminado
            editor.putInt("puntos", puntos);
            editor.apply();
            if(puntos <= 20){
                img_response.setImageResource(R.drawable.perrotriste);
            }
            String cadena = String.valueOf(puntos);
            Log.d("RESPUETSA", "Tiene el valor extra puntos hehehehehhehehhee");
            Log.d("RESPUETSA", cadena);
            text_puntos.setText(cadena);
        }

    }
// TODO: Hacer una activity de ultima respuesta, cambiar las vidas por corazoncitos,
//  cambiar el background del textViewPuntos, agregar mas animales,
}