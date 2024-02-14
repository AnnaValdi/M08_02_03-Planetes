package com.example.m08_02_03_planetes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class SatellitesAdapter (context: Context, val layout: Int, var satellites: List<Satellite> ):
    ArrayAdapter<Satellite>(context, layout, satellites)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view: View

        if(convertView != null){
            view = convertView
        }else{
            view =
                LayoutInflater.from(getContext()).inflate(layout, parent, false)
        }

        bindSatellite(view, satellites[position])

        return view
    }
    fun bindSatellite(view: View, satellite: Satellite){
        val imgPlanet = view.findViewById(R.id.ImgDetailPlanetImage) as ImageView
        imgPlanet.setImageResource(satellite.image)

        val lblSatelliteName = view.findViewById(R.id.LblSatelliteName) as TextView
        lblSatelliteName.text  = satellite.name
    }
}