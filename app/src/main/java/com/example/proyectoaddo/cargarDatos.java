package com.example.proyectoaddo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class cargarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cargar_datos);

        //Animaciones
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        ImageView logo = findViewById(R.id.imgLogo);

        logo.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = null;

                if(cargarNombre())
                {
                    intent = new Intent(cargarDatos.this, MainActivity.class);
                }
                else
                {
                    intent = new Intent(cargarDatos.this, Inicio.class);
                }
                startActivity(intent);
                finish();
            }
        },4000);
    }

    public boolean cargarNombre()
    {
        SharedPreferences preferences = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        String nombre = preferences.getString("Nombre","");
        if(nombre.equals(""))
            return true;
        else
            return false;
    }
}