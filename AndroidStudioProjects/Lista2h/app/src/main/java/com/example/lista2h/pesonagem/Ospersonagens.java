package com.example.lista2h.pesonagem;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lista2h.R;

public class Ospersonagens extends AppCompatActivity {
    ListView listView;

    String nomePersonagem[] = {"Shrek", "Thor-Gordo", "Mulher-Maravilha",
            "Poro", "Opressor", "Reflexo",
            "Obama", "Jaziel", "Fogueira",};
    int imgPersonagem[] = {R.drawable.shrek, R.drawable.thor, R.drawable.mulher,
            R.drawable.poro, R.drawable.opressor, R.drawable.reflexo,
            R.drawable.obama, R.drawable.jaziel, R.drawable.descanse};
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listaPersonagens);

        CustomAdapter customAdapter = new CustomAdapter();
    }
}

public class CustomAdapter extends BaseAdapter{
    @Override
    public int getCount() {
        return imgPersonagem.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}