package com.example.weatherappwithmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherappwithmvvm.model.CurrentWeather

class CityListViewModel : ViewModel() {

    val citiees = MutableLiveData<List<CurrentWeather>>()

    fun getDataFromInternet(){

    }

}