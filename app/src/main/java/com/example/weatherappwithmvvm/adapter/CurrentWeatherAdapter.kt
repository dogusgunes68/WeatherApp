package com.example.weatherappwithmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappwithmvvm.databinding.CurrentweatherRowBinding
import com.example.weatherappwithmvvm.view.CityListFragmentDirections
import com.example.weatherappwithmvvm.view.searchView


class CurrentWeatherAdapter(var cities : ArrayList<String>) : RecyclerView.Adapter<CurrentWeatherAdapter.CityHolder>(),CityClickListener {

    class CityHolder(val binding: CurrentweatherRowBinding) : RecyclerView.ViewHolder(binding.root) {



    }

    fun changeList(newCities : ArrayList<String>){
        this.cities = newCities
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
       val binding = CurrentweatherRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CityHolder(binding)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {

        holder.binding.cityAndCountryNameText.text = cities[position]

        holder.itemView.setOnClickListener {
            val city = cities[position]
            searchView?.isIconified = true
            val action = CityListFragmentDirections.actionCityListFragmentToCurrentWeatherFragment(city)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return cities.size
    }

    fun updateData(){

    }

    override fun cityClicked(view: View) {
        TODO("Not yet implemented")
    }

}