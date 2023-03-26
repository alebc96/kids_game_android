package com.alebc96.animalquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcercaActivity extends AppCompatActivity {

    private Button btn_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        btn_link = findViewById(R.id.buttonFlaticon);

        btn_link.setOnClickListener( view -> {
            abrirLink(view);
        });


    }

    public void abrirLink(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flaticon.es"));
        startActivity(browserIntent);
    }
}