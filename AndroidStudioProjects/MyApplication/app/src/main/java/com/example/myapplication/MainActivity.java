package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.implementar_dados);

        dialog.setCancelable(false);

        Button reconect = dialog.findViewById((R.id.button_reconect)); if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        }

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        Button enviar = dialog.findViewById(R.id.button_enviar);

        button = findViewById(R.id.medir_button);

      System.out.println("Reconectando");
      System.out.println("Implementando dados");

    }
}