package com.alebc96.animalquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {
    private int puntos;
    private TextView last_text;
    private ImageView last_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        SharedPreferences sharedPreferences = getSharedPreferences("Preferences", MODE_PRIVATE);
        puntos = sharedPreferences.getInt("puntos", 0);

        last_text = findViewById(R.id.textLastResponse);
        last_image = findViewById(R.id.imageLastResponse);

        if(puntos <= 20){
            last_image.setImageResource(R.drawable.perrotriste);
        }else {
            last_image.setImageResource(R.drawable.perrofeliz);
        }

        String cadena = String.valueOf(puntos);
        last_text.setText(cadena);



    }
}