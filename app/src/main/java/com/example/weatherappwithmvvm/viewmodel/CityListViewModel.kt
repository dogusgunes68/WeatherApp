package com.example.weatherappwithmvvm.viewmodel

import android.widget.ArrayAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherappwithmvvm.adapter.CurrentWeatherAdapter
import com.example.weatherappwithmvvm.model.City
import com.example.weatherappwithmvvm.model.CurrentWeather
import com.example.weatherappwithmvvm.service.CurrentWeatherApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CityListViewModel : ViewModel() {

    val cities = MutableLiveData<ArrayList<City>>()
    private val disposable = CompositeDisposable()

    private val currentWeatherApiService = CurrentWeatherApiService()

    fun getCitiesFromNet(){

        disposable.add(currentWeatherApiService.getCities().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<City>>(){
                override fun onSuccess(t: List<City>) {
                    cities.value = t as ArrayList<City>
                }

                override fun onError(e: Throwable) {
                    println("Error : "+e.localizedMessage)
                }

            })

        )

    }


}