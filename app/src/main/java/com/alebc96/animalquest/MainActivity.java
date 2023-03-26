package com.alebc96.animalquest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btn_top_left;
    private Button btn_top_right;
    private Button btn_bottom_left;
    private Button btn_bottom_right;
    private ImageView animal_image;
    private String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_top_left = findViewById(R.id.btn_to_left);
        btn_top_right = findViewById(R.id.btn_top_right);
        btn_bottom_left = findViewById(R.id.btn_bottom_left);
        btn_bottom_right = findViewById(R.id.btn_bottom_right);
        animal_image = findViewById(R.id.imageAnimal);

    }



}