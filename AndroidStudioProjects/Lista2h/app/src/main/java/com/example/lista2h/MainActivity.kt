package com.example.lista2h.pesonagem;

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    //Declarar a variável que irá receber a ListView do XML
    var listView: ListView? = null

    //Criar os arrays que serão inseridos na listView
    var nomePlanetas = arrayOf(
        "Jupiter", "Lua", "Marte", "Mercurio",
        "Netuno", "Plutão", "Saturno", "Sol", "Terra", "Urano", "Venus"
    )
    var imgPlanetas = intArrayOf(
        R.drawable.jupiter, R.drawable.lua,
        R.drawable.marte, R.drawable.mercurio, R.drawable.netuno,
        R.drawable.plutao, R.drawable.saturno, R.drawable.sol,
        R.drawable.terra, R.drawable.urano, R.drawable.venus
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //a variavel listview está recebendo a listView XML
        listView = findViewById(R.id.listaPlanetas)

        //Criar o objeto/classe que irá inserir o modelo na listView
        val adapter = CustomAdapter()

        //Carregar o baseAdapter na listView
        listView.setAdapter(adapter)

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Cliquei no item da lista de nome: " + nomePlanetas[position],
                        Toast.LENGTH_SHORT).show();
            }
        });*/

        //Criando evento de click na listView
        listView.setOnItemClickListener(OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(applicationContext, VisualizaPlaneta_MainActivity::class.java)
            //Passando valores de uma janela para outra
            intent.putExtra("nomePlaneta", nomePlanetas[i])
            intent.putExtra("imagemPlaneta", imgPlanetas[i])
            startActivity(intent)
        })
    }

    //inner class - Classe dentro de outra Classe
    inner class CustomAdapter : BaseAdapter() {
        override fun getCount(): Int {
            return imgPlanetas.size
        }

        override fun getItem(i: Int): Any {
            return null
        }

        override fun getItemId(i: Int): Long {
            return 0
        }

        //Montar o modelo para ser inserido na lista de planetas - ListView
        override fun getView(position: Int, view: View, viewGroup: ViewGroup): View {
            val txtNomePlaneta: TextView
            val imagemPlaneta: ImageView

            //instanciando o modelo com os componentes para inserir na Lista
            val carregaView: View = layoutInflater.inflate(R.layout.modelo_lista_planetas, null)
            txtNomePlaneta = carregaView.findViewById(R.id.txtListaPlaneta)
            imagemPlaneta = carregaView.findViewById(R.id.imgListaPlaneta)

            //Carregando os valores nos componentes
            txtNomePlaneta.text = nomePlanetas[position]
            imagemPlaneta.setImageResource(imgPlanetas[position])
            return carregaView
        }
    }
}