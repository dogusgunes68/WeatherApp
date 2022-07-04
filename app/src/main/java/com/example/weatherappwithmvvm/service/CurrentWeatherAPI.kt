package com.example.weatherappwithmvvm.service

import com.example.weatherappwithmvvm.model.City
import com.example.weatherappwithmvvm.model.CurrentWeather
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherAPI {

    //https://raw.githubusercontent.com/dogusgunes68/Cities.json/master/Cities.json

    @GET("weather?&appid=YOUR_API_KEY")
    fun getCurrentWeather(@Query("q") cityName : String) : Single<CurrentWeather>

    @GET("dogusgunes68/Cities.json/master/Cities.json")
    fun getCities() : Single<List<City>>

}
