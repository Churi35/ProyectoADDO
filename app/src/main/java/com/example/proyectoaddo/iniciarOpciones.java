package com.example.proyectoaddo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class iniciarOpciones extends AppCompatActivity {

    ImageButton btnBackO;
    Button btnHablar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_opciones);

        btnBackO = findViewById(R.id.btnBackO);
        btnHablar = findViewById(R.id.btnHablar);

        btnBackO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnHablar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),hablarActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}