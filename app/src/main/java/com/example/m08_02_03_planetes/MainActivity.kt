package com.example.m08_02_03_planetes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var planets = mutableListOf(Planet("Mercury", 0, R.drawable.mercury), Planet("Venus",0, R.drawable.venus),
                                    Planet("Earth", 1, R.drawable.earth), Planet("Mars",2, R.drawable.mars),
                                    Planet("Jupiter", 72, R.drawable.jupiter), Planet("Saturn",82, R.drawable.saturn),
                                    Planet("Uranus", 27, R.drawable.uranus), Planet("Neptune", 14, R.drawable.neptune))

        val lstPlanets = findViewById(R.id.LstPlanets) as ListView
        val btnOk      = findViewById(R.id.BtnOk) as Button

        val adapter = PlanetsAdapter(this, R.layout.planets_item, planets)
        lstPlanets.adapter = adapter

        lstPlanets.onItemClickListener = AdapterView.OnItemClickListener(){
            _, _, i, _ ->

            val lblPlanetName = findViewById(R.id.LblPlanetName) as TextView
            lblPlanetName.text = "You have chosen the planet " + planets[i].name
        }

        lstPlanets.onItemLongClickListener = AdapterView.OnItemLongClickListener()
        {
            _, _, i, _ ->

            val planet = planets[i]
            planets.removeAt(i)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Planet "+planet+" was deleted", Toast.LENGTH_LONG).show()

            true
        }

        btnOk.setOnClickListener(){
            val txtNewPlanet = findViewById(R.id.TxtNewPlanet) as EditText
            val newPlanetName = txtNewPlanet.text.toString()
            val txtNumSatellites = findViewById(R.id.TxtSatellites) as EditText
            val numSatellites = txtNumSatellites.text.toString().toInt()

            if(newPlanetName != ""){
                val newPlanet = Planet(newPlanetName, numSatellites, R.drawable.eris)
                planets.add(newPlanet)
                txtNewPlanet.setText("")
                txtNumSatellites.setText("")
                adapter.notifyDataSetChanged()
            }else{
                val lblPlanetName = findViewById(R.id.LblPlanetName) as TextView
                lblPlanetName.text = "You must write the plane name"
            }
        }
    }
}