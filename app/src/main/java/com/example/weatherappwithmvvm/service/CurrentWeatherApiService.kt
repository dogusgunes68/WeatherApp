package com.example.weatherappwithmvvm.service

import com.example.weatherappwithmvvm.model.City
import com.example.weatherappwithmvvm.model.CurrentWeather
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CurrentWeatherApiService {

    private val WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private val CITY_BASE_URL = "https://raw.githubusercontent.com/"
    private val weather_api = Retrofit.Builder()
            .baseUrl(WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CurrentWeatherAPI::class.java)


    fun getCurrentWeatherData(cityName : String) : Single<CurrentWeather>{
        return weather_api.getCurrentWeather(cityName)
    }

    private val city_api = Retrofit.Builder()
        .baseUrl(CITY_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CurrentWeatherAPI::class.java)


    fun getCities() : Single<List<City>>{
        return city_api.getCities()
    }


}