package com.example.proyectoaddo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    Button btnsalir,btnCharla,btnContacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        cargarNombre();

        btnsalir = findViewById(R.id.btnSalir);
        btnCharla = findViewById(R.id.btnCharla);
        btnContacto = findViewById(R.id.btnContacto);

        btnCharla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),iniciarOpciones.class);
                startActivity(intent);
            }
        });

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),contactarActivity.class);
                startActivity(intent);
            }
        });

        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void cargarNombre()
    {
        SharedPreferences preferences = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        String nombre = preferences.getString("Nombre","");

        Toast.makeText(this,"Bienvenido "+nombre,Toast.LENGTH_LONG).show();
    }
}