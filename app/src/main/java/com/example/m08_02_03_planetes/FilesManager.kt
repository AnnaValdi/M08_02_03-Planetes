package com.example.m08_02_03_planetes

class FilesManager {
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