package com.example.m08_02_03_planetes

import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity()
{
    object planetConstants
    {
        const val PLANET = "PLANET"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = getIntent()
        val planet = intent.getSerializableExtra(planetConstants.PLANET) as Planet

        val lblPlanetName  = findViewById(R.id.LblDetailPlanetName) as TextView
        val imgPlanetImage = findViewById(R.id.ImgDetailPlanetImage) as ImageView
        val lstSatellites  = findViewById(R.id.LstSatellites) as GridView
        val btnBack        = findViewById(R.id.BtnBack) as Button

        lblPlanetName.text = planet.name
        imgPlanetImage.setImageResource(planet.image)


        val adapter = SatellitesAdapter(this, R.layout.satellites_item, planet.satellites)
        lstSatellites.adapter = adapter
    }
}