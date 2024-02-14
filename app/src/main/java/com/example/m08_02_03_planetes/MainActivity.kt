package com.example.m08_02_03_planetes

import android.content.Intent
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

        var planets = getPlanets()
        val lstPlanets = findViewById(R.id.LstPlanets) as ListView
        val btnOk      = findViewById(R.id.BtnOk) as Button

        val adapter = PlanetsAdapter(this, R.layout.planets_item, planets)
        lstPlanets.adapter = adapter

        lstPlanets.onItemClickListener = AdapterView.OnItemClickListener(){
            _, _, i, _ ->

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.planetConstants.PLANET, planets[i])
            startActivity(intent)
        }

        lstPlanets.onItemLongClickListener = AdapterView.OnItemLongClickListener()
        {
            _, _, i, _ ->

            val planet = planets[i]
            planets.removeAt(i)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Planet "+planet.name+" was deleted", Toast.LENGTH_LONG).show()

            true
        }

        btnOk.setOnClickListener(){
            val txtNewPlanet = findViewById(R.id.TxtNewPlanet) as EditText
            val newPlanetName = txtNewPlanet.text.toString()
            val txtNumSatellites = findViewById(R.id.TxtSatellites) as EditText
            val numSatellites = txtNumSatellites.text.toString().toInt()

            if(newPlanetName != ""){
                val newPlanet = Planet(newPlanetName, numSatellites, R.drawable.eris, listOf())
                planets.add(newPlanet)
                txtNewPlanet.setText("")
                txtNumSatellites.setText("")
                adapter.notifyDataSetChanged()
            }else{
                //val lblPlanetName = findViewById(R.id.LblPlanetName) as TextView
                //lblPlanetName.text = "You must write the planet name"
            }
        }
    }
    fun getPlanets(): MutableList<Planet>{
        return mutableListOf(Planet("Mercury", 0, R.drawable.mercury, listOf()), Planet("Venus",0, R.drawable.venus, listOf()),
            Planet("Earth", 1, R.drawable.earth, listOf(Satellite("Moon", R.drawable.earth))), Planet("Mars",2, R.drawable.mars, listOf()),
            Planet("Jupiter", 72, R.drawable.jupiter, listOf(Satellite("Ie", R.drawable.earth), Satellite("Europa", R.drawable.earth))), Planet("Saturn",82, R.drawable.saturn, listOf()),
            Planet("Uranus", 27, R.drawable.uranus, listOf(Satellite("Titan", R.drawable.earth))), Planet("Neptune", 14, R.drawable.neptune, listOf(Satellite("Triton", R.drawable.earth))),
            Planet("Mercury", 0, R.drawable.mercury, listOf()), Planet("Venus",0, R.drawable.venus, listOf()),
            Planet("Earth", 1, R.drawable.earth, listOf(Satellite("Moon", R.drawable.earth))), Planet("Mars",2, R.drawable.mars, listOf()),
            Planet("Jupiter", 72, R.drawable.jupiter, listOf(Satellite("Ie", R.drawable.earth), Satellite("Europa", R.drawable.earth))), Planet("Saturn",82, R.drawable.saturn, listOf()),
            Planet("Uranus", 27, R.drawable.uranus, listOf(Satellite("Titan", R.drawable.earth))), Planet("Neptune", 14, R.drawable.neptune, listOf(Satellite("Triton", R.drawable.earth))),
            Planet("Mercury", 0, R.drawable.mercury, listOf()), Planet("Venus",0, R.drawable.venus, listOf()),
            Planet("Earth", 1, R.drawable.earth, listOf(Satellite("Moon", R.drawable.earth))), Planet("Mars",2, R.drawable.mars, listOf()),
            Planet("Jupiter", 72, R.drawable.jupiter, listOf(Satellite("Ie", R.drawable.earth), Satellite("Europa", R.drawable.earth))), Planet("Saturn",82, R.drawable.saturn, listOf()),
            Planet("Uranus", 27, R.drawable.uranus, listOf(Satellite("Titan", R.drawable.earth))), Planet("Neptune", 14, R.drawable.neptune, listOf(Satellite("Triton", R.drawable.earth))))

    }
}