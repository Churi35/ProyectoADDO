package com.example.proyectoaddo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class contactarActivity extends AppCompatActivity {

    ImageButton btnBackC;
    Button btnEviarC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactar);

        btnBackC = findViewById(R.id.btnBackC);
        btnEviarC = findViewById(R.id.btnEviarC);


        btnBackC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnEviarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] correo = {"HtoH@gmail.com"};
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, correo);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Sugerencias");

                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(Intent.createChooser(intent, "Enviando email..."));
                else
                    Toast.makeText(view.getContext(),"No existe una app instalada",Toast.LENGTH_LONG).show();
            }
        });
    }
}