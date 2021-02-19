package com.example.weatherappwithmvvm.service

import com.example.weatherappwithmvvm.model.CurrentWeather
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherAPI {

    //api.openweathermap.org/data/2.5/weather?q={city name}&appid=c1b61589ad3d6cd9c2b213282c2197e4

    @GET("weather?&appid=c1b61589ad3d6cd9c2b213282c2197e4")
    fun getCurrentWeather(@Query("q") cityName : String) : Single<CurrentWeather>

}