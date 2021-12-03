package com.example.mapadivertido

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : FragmentActivity(), OnMapReadyCallback {
    //variável global
    private var mMap: GoogleMap? = null
    var latitude = 0.0
    var longitude = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        //Variavel para configuração das estruturas do mapa.
        mMap = googleMap

        //Tipo de mapas
        /*
        Normal
            Mapa rodoviário comum. Mostra vias, alguns elementos criados pelo homem e
            recursos naturais importantes, como rios. Etiquetas de estradas e de elementos
             também são visíveis.
        Híbrido
            Dados de fotografia de satélite com mapas rodoviários. Etiquetas de estradas
             e de elementos também são visíveis.
        Satélite
            Dados de fotografia de satélite. Marcadores de estradas e de elementos não são visíveis.
        Relevo
            Dados topográficos. O mapa inclui cores, curvas de nível e etiquetas, além de sombreamento
             de perspectiva. Algumas vias e etiquetas também são visíveis.
        Nenhum
            Nenhum bloco. O mapa será renderizado como uma grade vazia, sem carregar blocos.
        */

        //método para alterar o tipo de mapa
        mMap!!.mapType = GoogleMap.MAP_TYPE_NORMAL
        latitude = -23.5856101
        longitude = -46.6669873
        val local = "Parque do Ibirapuera"
        val posicao = LatLng(latitude, longitude)
        mMap!!.addMarker(
            MarkerOptions()
                .position(posicao)
                .snippet("Local do parque do ibirapuera") //.icon(BitmapDescriptorFactory.defaultMarker(
                //        BitmapDescriptorFactory.HUE_VIOLET
                // ))
                //Icone costumizado
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.holy))
                .title(local)
        )

        //Movimento da camera conforme a necessidade.
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(posicao, 15f))

        //Adicionando evento de click no mapa
        mMap!!.setOnMapClickListener { latLng ->
            val latitude: Double
            val longitude: Double
            latitude = latLng.latitude
            longitude = latLng.longitude
            Toast.makeText(
                this@MapsActivity,
                "Click curto - Lat: $latitude Long: $longitude",
                Toast.LENGTH_SHORT
            ).show()
            //Gerando marcador de click normal
            mMap!!.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title("Clique curto")
                    .snippet("Descrição do click curto")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.crashf))
            )
            mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18f))
        }

        //Gerando double click
        mMap!!.setOnMapLongClickListener { latLng -> //Salvando a latitude e longitude
            val latitute: Double
            val longitude: Double
            latitute = latLng.latitude
            longitude = latLng.longitude
            Toast.makeText(
                this@MapsActivity,
                "Click Longo - Lat: " + latitute + "Lon: " + longitude,
                Toast.LENGTH_SHORT
            ).show()
            mMap!!.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title("Click longo")
                    .snippet("Descrição do click longo")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.crash))
            )
            mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18f))
        }

    }
}