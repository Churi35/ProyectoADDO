package com.example.proyectoaddo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class iniciarOpciones extends AppCompatActivity {

    ImageButton btnBackO;
    Button btnHablar,btnConsejo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_opciones);

        btnBackO = findViewById(R.id.btnBackO);
        btnHablar = findViewById(R.id.btnHablar);
        btnConsejo = findViewById(R.id.btnConsejo);

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

        btnConsejo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialog();
            }
        });


    }

    private void mostrarDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_consejo,null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView txtConsejo = view.findViewById(R.id.txtConsejo);
        String consejo = "El mejor consejo que mi sistema puede dar es, que sin importar la situacion lo mejor es tomarse 10 mintos al día para relajar la mente";
        txtConsejo.setText(consejo);

        Button btnCerrarD = view.findViewById(R.id.btnCerrarD);
        btnCerrarD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}