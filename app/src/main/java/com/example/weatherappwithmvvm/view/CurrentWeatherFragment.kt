package com.example.weatherappwithmvvm.view

import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Picture
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.weatherappwithmvvm.R
import com.example.weatherappwithmvvm.databinding.ActivityMainBinding
import com.example.weatherappwithmvvm.databinding.CurrentweatherRowBinding
import com.example.weatherappwithmvvm.databinding.FragmentCurrentWeatherBinding
import com.example.weatherappwithmvvm.util.addBackroundImage
import com.example.weatherappwithmvvm.viewmodel.CurrentWeatherViewModel


class CurrentWeatherFragment : Fragment() {

    //api.openweathermap.org/data/2.5/weather?q={city name}&appid=c1b61589ad3d6cd9c2b213282c2197e4

    private var _binding: FragmentCurrentWeatherBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : CurrentWeatherViewModel
    private lateinit var city : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentCurrentWeatherBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainConstraintLayout.setBackgroundResource(R.drawable.weather)

        arguments?.let {
            city = CurrentWeatherFragmentArgs.fromBundle(it).city
        }

        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)

        observeLiveData()

        if(city != ""){
            viewModel.refreshData(city)
        }
        binding.swipeRefreshLayout.setOnRefreshListener {
            if(city != ""){
                binding.progressBar.visibility = View.VISIBLE
                binding.errorText.visibility = View.GONE

                binding.cityNameText.visibility = View.GONE
                binding.temperatureText.visibility = View.GONE
                binding.humidityText.visibility = View.GONE
                binding.typeText.visibility = View.GONE
                binding.descriptionText.visibility = View.GONE

                viewModel.refreshData(city)

            }
            binding.swipeRefreshLayout.isRefreshing = false
        }

        binding.errorText.visibility = View.GONE
        binding.progressBar.visibility = View.GONE

    }

    fun observeLiveData(){

        viewModel.currentWeather.observe(viewLifecycleOwner, Observer { currentWeather ->

            currentWeather.let {
                binding.errorText.visibility = View.GONE
                binding.progressBar.visibility = View.GONE

                binding.cityNameText.visibility = View.VISIBLE
                binding.temperatureText.visibility = View.VISIBLE
                binding.humidityText.visibility = View.VISIBLE
                binding.typeText.visibility = View.VISIBLE
                binding.descriptionText.visibility = View.VISIBLE

                binding.cityNameText.text = currentWeather.name
                binding.temperatureText.text = (currentWeather.main.temp - 273).toInt().toString()+"°C"
                binding.humidityText.text = "%"+currentWeather.main.humidity.toString()
                binding.typeText.text = currentWeather.weather[0].main
                binding.descriptionText.text = currentWeather.weather[0].description

                binding.mainConstraintLayout.addBackroundImage(binding.typeText.text.toString(),binding.mainConstraintLayout)

            }

        })

        viewModel.currentWeatherError.observe(viewLifecycleOwner, Observer { error ->

            error.let {

                if (it){
                    binding.cityNameText.visibility = View.GONE
                    binding.temperatureText.visibility = View.GONE
                    binding.humidityText.visibility = View.GONE
                    binding.typeText.visibility = View.GONE
                    binding.descriptionText.visibility = View.GONE

                    binding.errorText.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE

                }else{

                    binding.errorText.visibility = View.GONE

                }

            }

        })

        viewModel.currentWeatherLoading.observe(viewLifecycleOwner, Observer {loading ->

            loading.let {

                if (it){
                    binding.cityNameText.visibility = View.GONE
                    binding.temperatureText.visibility = View.GONE
                    binding.humidityText.visibility = View.GONE
                    binding.typeText.visibility = View.GONE
                    binding.descriptionText.visibility = View.GONE

                    binding.errorText.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }else{
                    binding.progressBar.visibility = View.INVISIBLE
                }

            }

        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}