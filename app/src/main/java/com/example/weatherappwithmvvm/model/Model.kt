package com.example.weatherappwithmvvm.model

data class CurrentWeather(val coord: Coord,val weather: List<Weather>,val main: Main,val name : String)

data class Coord(val latitude : Double,val longitude : Double)

data class Weather(val id : Int, val main : String, val description : String, val icon : String)

data class Main(val temp : Double,val feels_like : Double, val temp_min : Double, val temp_max : Double, val humidity : Double)