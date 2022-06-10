package com.example.proyectoaddo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtNombre;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNombre.getText().toString().isEmpty())
                    Toast.makeText(view.getContext(),"Ingrese su nombre",Toast.LENGTH_LONG).show();
                else
                {
                    guardarNombre();
                    Intent intent = new Intent(view.getContext(),Inicio.class);
                    startActivity(intent);
                    finish();

                }


            }
        });
    }

    public void guardarNombre()
    {
        SharedPreferences preferences = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        String Nombre = txtNombre.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("Nombre",Nombre);

        editor.commit();
    }
}