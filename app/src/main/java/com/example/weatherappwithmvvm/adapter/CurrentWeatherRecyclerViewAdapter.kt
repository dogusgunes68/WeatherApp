package com.example.weatherappwithmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappwithmvvm.R
import kotlinx.android.synthetic.main.currentweather_row.view.*


class CurrentWeatherRecyclerViewAdapter(var cities : ArrayList<String>) : RecyclerView.Adapter<CurrentWeatherRecyclerViewAdapter.CityHolder>(),CityClickListener {

    class CityHolder(view : View) : RecyclerView.ViewHolder(view) {



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currentweather_row,parent,false)
        return CityHolder(view)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {

        holder.itemView.cityAndCountryNameText.text = cities[position]

    }

    override fun getItemCount(): Int {
        return cities.size
    }

    override fun cityClicked(view: View) {
        TODO("Not yet implemented")
    }

}