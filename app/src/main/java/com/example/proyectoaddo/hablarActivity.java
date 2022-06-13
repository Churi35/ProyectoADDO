package com.example.proyectoaddo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class hablarActivity extends AppCompatActivity {

    ImageButton btnBackH;
    EditText txtDia;
    Button btnEnviarD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hablar);

        btnBackH = findViewById(R.id.btnBackH);
        txtDia = findViewById(R.id.txtDia);
        btnEnviarD = findViewById(R.id.btnEnviarD);

        btnBackH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnEnviarD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Dia = txtDia.getText().toString();

                if(!Dia.isEmpty())
                    Toast.makeText(view.getContext(),"Gracias por compartir tu día conmigo :)",Toast.LENGTH_LONG).show();

                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"No importa si no quires contarme ahorita, aquí estare esperandote",Toast.LENGTH_LONG).show();
    }
}