package com.example.weatherappwithmvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherappwithmvvm.adapter.CurrentWeatherAdapter
import com.example.weatherappwithmvvm.databinding.FragmentCityListBinding
import com.example.weatherappwithmvvm.viewmodel.CityListViewModel


class CityListFragment() : Fragment() {

    private  var _binding: FragmentCityListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : CityListViewModel

    private lateinit var currentWeatherAdapter : CurrentWeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCityListBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CityListViewModel::class.java)
        viewModel.getCitiesFromNet()
        observeLiveData()



    }

    private fun observeLiveData(){
        viewModel.cities.observe(viewLifecycleOwner, Observer {cities->
            cities?.let {
                if (cities.size != 0){
                    currentWeatherAdapter = CurrentWeatherAdapter(cities)
                    binding.cityListRecycler.layoutManager = LinearLayoutManager(context)
                    binding.cityListRecycler.adapter = currentWeatherAdapter
                    currentWeatherAdapter.notifyDataSetChanged()
                }
            }
        })
    }





}