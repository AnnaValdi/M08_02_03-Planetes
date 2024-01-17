package com.example.m08_02_03_planetes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PlanetsAdapter (context: Context, val layout: Int, val planets: MutableList<Planet> ):
    ArrayAdapter<Planet>(context, layout, )
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view: View

        if(convertView != null){
            view = convertView
        }else{
            view =
                LayoutInflater.from(getContext()).inflate(layout, parent, false)
        }

        bindPlanet(view, planets[position])

        return view
    }

    fun bindPlanet(view: View, planet: Planet){
        val imgPlanet = view.findViewById(R.id.ImgListPlanet)as ImageView
        imgPlanet.setImageResource(planet.image)

        val lblPlanetName = view.findViewById(R.id.LblPlanetName) as TextView
        lblPlanetName.text = planet.name

        val lblSatellites = view.findViewById(R.id.LblListSatellites) as TextView
        lblSatellites.text = "Satellites: "+planet.satellites

    }

}