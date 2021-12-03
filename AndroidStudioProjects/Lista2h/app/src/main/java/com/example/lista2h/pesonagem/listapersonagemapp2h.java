package com.example.lista2h.pesonagem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VisualizaPersonagem_MainActivity extends AppCompatActivity {

    TextView txtPersonagem;
    ImageView imgPersonagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modelo);

        txtPersonagem = findViewById(R.id.txtPersonagem);
        imgPersonagem = findViewById(R.id.imgPersonagem);
        desPersonagem = findViewById(R.id.imgPersonagem);
        //Receber o valor de outra janela
        Intent intent = getIntent();

        //Recebendo os valores pela variável declarada na janela de origem
        String nPlaneta = intent.getStringExtra("nomePersonagem");
        int mPlaneta = intent.getIntExtra("imagemPersonagem",0);

        //Inserindo os valores nos componentes
        txtPersonagem.setText(nPlaneta);
        imgPersonagem.setImageResource(mPlaneta);
    }
}
