package com.example.weatherappwithmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherappwithmvvm.model.CurrentWeather
import com.example.weatherappwithmvvm.service.CurrentWeatherApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CurrentWeatherViewModel() :  ViewModel(){

    private val currentWeatherApiService = CurrentWeatherApiService()
    private val disposable = CompositeDisposable()

    val currentWeather = MutableLiveData<CurrentWeather>()
    val currentWeatherError = MutableLiveData<Boolean>()
    val currentWeatherLoading = MutableLiveData<Boolean>()

    fun refreshData(city  :String){
        if (city != null)
        getDataFromNet(city)
    }


    fun getDataFromNet(city : String){

        currentWeatherLoading.value = true

        disposable.add(currentWeatherApiService.getCurrentWeatherData(city)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<CurrentWeather>(){
                    override fun onSuccess(t: CurrentWeather) {
                        currentWeather.value = t
                        currentWeatherLoading.value = false
                        currentWeatherError.value = false

                        println(t.name)
                    }

                    override fun onError(e: Throwable) {
                        currentWeatherLoading.value = false
                        currentWeatherError.value = true
                        e.printStackTrace()
                    }

                })

        )

    }

}