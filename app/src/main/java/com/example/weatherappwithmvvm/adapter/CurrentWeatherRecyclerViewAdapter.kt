package com.example.weatherappwithmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappwithmvvm.R
import com.example.weatherappwithmvvm.model.City

class CurrentWeatherRecyclerViewAdapter(val cities : ArrayList<City>) : RecyclerView.Adapter<CurrentWeatherRecyclerViewAdapter.CityHolder>(){

    class CityHolder(view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currentweather_row,parent,false)
        return CityHolder(view)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return cities.size
    }

}