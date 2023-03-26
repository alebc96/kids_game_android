package com.alebc96.animalquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    int cantVidas = 3;
    int puntos = 0;
    int numeroGenerado = 0;
    private Button btn_top_left;
    private Button btn_top_right;
    private Button btn_bottom_left;
    private Button btn_bottom_right;
    private ImageView animal_image, corazon1, corazon2, corazon3;
    private String response;
    private TextView  puntosView, textCcountDown;

    String[] nombre_animal = {"ballena", "caballo", "cangrejo", "canguro", "cerdo", "coala",
            "elefante", "gallina", "gato", "jirafa", "llama", "mono", "morsa", "oso", "oso panda",
            "oveja", "perro", "pinguino", "polluelo", "pulpo", "serpiente", "tiburon",
            "tortuga", "vaca", "bisonte", "buho", "delfin", "hiena", "hipopotamo", "lobo",
            "mantarraya", "pavo", "tigre", "zorro", "pollo"
    };
    String[] imagenes_animales = {"ballena", "caballo", "cangrejo", "canguro", "cerdo", "coala",
            "elefante", "gallina", "gato", "jirafa", "llama", "mono", "morsa", "oso", "osopanda",
            "oveja", "perro", "pinguino", "polluelo", "pulpo", "serpiente", "tiburon",
            "tortugamarina", "vaca"};


    public int[] imagenes_animales_drawable = {R.drawable.ballena, R.drawable.caballo, R.drawable.cangrejo,
    R.drawable.canguro, R.drawable.cerdo, R.drawable.coala, R.drawable.elefante, R.drawable.gallina,
            R.drawable.gato, R.drawable.jirafa, R.drawable.llama, R.drawable.mono, R.drawable.morsa,
            R.drawable.oso, R.drawable.osopanda, R.drawable.oveja, R.drawable.perro, R.drawable.pinguino,
            R.drawable.polluelo, R.drawable.pulpo, R.drawable.serpiente, R.drawable.tiburon,
            R.drawable.tortugamarina, R.drawable.vaca, R.drawable.bisonte, R.drawable.buho,
            R.drawable.delfin, R.drawable.hiena, R.drawable.hipopotamo, R.drawable.lobo,
            R.drawable.mantarraya, R.drawable.pavo, R.drawable.tigre, R.drawable.zorro,R.drawable.pollo
    };

    public ArrayList<String> nombre_animales_array = new ArrayList<>(Arrays.asList(nombre_animal));
    public ArrayList<String> imagenes_animales_array = new ArrayList<>(Arrays.asList(imagenes_animales));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btn_top_left = findViewById(R.id.btn_to_left);
        btn_top_right = findViewById(R.id.btn_top_right);
        btn_bottom_left = findViewById(R.id.btn_bottom_left);
        btn_bottom_right = findViewById(R.id.btn_bottom_right);
        animal_image = findViewById(R.id.imageAnimal) ;
        puntosView = findViewById(R.id.textPuntos);
        textCcountDown = findViewById(R.id.textCountDown);
        corazon1 = findViewById(R.id.corazon1);
        corazon2 = findViewById(R.id.corazon2);
        corazon3 = findViewById(R.id.corazon3);
        Button[] botones = new Button[4];
        botones[0] = btn_bottom_left;
        botones[1] = btn_top_right;
        botones[2] = btn_bottom_right;
        botones[3] = btn_top_left;

        // its the final countDown
        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                textCcountDown.setText("Tiempo restante: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Toast.makeText(GameActivity.this, "¡Se ha acabado el tiempo!",
                        Toast.LENGTH_SHORT).show();
                Intent page1 = new Intent(GameActivity.this, ResponseActivity.class);
                cantVidas = 3;
                page1.putExtra("puntos", puntos);
                startActivity(page1);
                finish();
            }
        }.start();

        //generando numeros aleatorios
        Random  random = new Random();
        int randInt = random.nextInt(nombre_animales_array.size());
        numeroGenerado = randInt;
        //cambiar nombre de los botones de manera aleatoria
        cambiarNombrebotones(nombre_animal, btn_bottom_left, btn_bottom_right, btn_top_left, btn_top_right);
        //cambiar imagen de forma aleatoria
        generarImagen(imagenes_animales_drawable, animal_image);
        setNombreBotonConRespuesta(botones);
        btn_bottom_left.setOnClickListener(view -> compararSeleccion(btn_bottom_left, botones));
        btn_bottom_right.setOnClickListener(view -> compararSeleccion(btn_bottom_right, botones));
        btn_top_left.setOnClickListener(view -> compararSeleccion(btn_top_left, botones));
        btn_top_right.setOnClickListener(view -> compararSeleccion(btn_top_right, botones));
    }

    public void cambiarNombrebotones(String[] lista, Button btn1, Button btn2, Button btn3, Button btn4){
        Random random = new Random();
        int indice = random.nextInt(lista.length);
        int indice2 = random.nextInt(lista.length);
        int indice3 = random.nextInt(lista.length);
        int indice4 = random.nextInt(lista.length);
        btn1.setText(lista[indice]);
        btn2.setText(lista[indice2]);
        btn3.setText(lista[indice3]);
        btn4.setText(lista[numeroGenerado]);
    }

    public void compararSeleccion(Button btn, Button[] btns){
        response = btn.getText().toString();
        if(response.equals(nombre_animales_array.get(numeroGenerado))){
            Log.d("Nombre de animal", nombre_animales_array.get(numeroGenerado));
            puntos++;
            String puntosText = "Puntos: " + puntos;
            puntosView.setText(puntosText);
            cambiarNombrebotones(nombre_animal, btn_bottom_left, btn_bottom_right, btn_top_left, btn_top_right);
            generarImagen(imagenes_animales_drawable, animal_image);
            setNombreBotonConRespuesta(btns);
            response = "";
        }else{
            cantVidas--;
            if(cantVidas == 2){
                corazon3.setVisibility(View.GONE);
            }else if( cantVidas == 1){
                corazon2 .setVisibility(View.GONE);
            }else if(cantVidas == 0){
                corazon3.setVisibility(View.GONE);
            }
            if(cantVidas == 0){
                Intent page1 = new Intent(GameActivity.this, ResponseActivity.class);
                cantVidas = 3;
                page1.putExtra("puntos", puntos);
                startActivity(page1);
                finish();

            }else{
                cambiarNombrebotones(nombre_animal, btn_bottom_left, btn_bottom_right, btn_top_left, btn_top_right);
                generarImagen(imagenes_animales_drawable, animal_image);
                setNombreBotonConRespuesta(btns);
            }
        }
    }

    public void setNombreBotonConRespuesta(Button[] btns){
        Random random = new Random();
        int indice = random.nextInt(btns.length);
        btns[indice].setText(nombre_animales_array.get(numeroGenerado));
    }

    public void cambiarimagen(int indice, ImageView img){
        Log.d("TAG***",imagenes_animales_array.get(indice));
        if(imagenes_animales_array.get(indice) != null){
            int id = getResources().getIdentifier(imagenes_animales_array.get(indice),
                    "mipmap",
                    getPackageName());
            img.setImageResource(id);
        }
    }

    public void generarImagen(int[] imagenes, ImageView img){
        Random raandom = new Random();
        int indice = raandom.nextInt(imagenes.length);
        Drawable imagen = getResources().getDrawable(imagenes[indice]);
        img.setImageDrawable(imagen);
        this.numeroGenerado = indice;
    }
}