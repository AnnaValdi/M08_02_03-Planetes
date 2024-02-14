package com.example.m08_02_03_planetes

import java.io.Serializable

class Planet (val name: String, val numSatellites: Int, val image: Int, val satellites: List<Satellite>)
    : Serializable