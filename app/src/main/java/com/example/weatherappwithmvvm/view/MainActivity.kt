package com.example.weatherappwithmvvm.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.weatherappwithmvvm.R
import com.example.weatherappwithmvvm.adapter.CurrentWeatherAdapter
import com.example.weatherappwithmvvm.databinding.ActivityMainBinding
import com.example.weatherappwithmvvm.model.City
import com.example.weatherappwithmvvm.viewmodel.CityListViewModel

var searchView : SearchView? = null
var cityList = listOf<City>()

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navigationController : NavController

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

            menuInflater.inflate(R.menu.toolbar_menu, menu)

            val searchItem = menu?.findItem(R.id.action_search)
            searchView = searchItem?.actionView as SearchView

        searchView?.setOnQueryTextListener(this)

        MenuItemCompat.setOnActionExpandListener(searchItem, object : MenuItemCompat.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                /*
                val action = CurrentWeatherFragmentDirections.actionCurrentWeatherFragmentToCityListFragment()
                navigationController.navigate(action)

                 */
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {

                val action = CityListFragmentDirections.actionCityListFragmentToCurrentWeatherFragment()
                navigationController.navigate(action)
                return true
            }
        })

        searchView?.setOnSearchClickListener {
            val action = CurrentWeatherFragmentDirections.actionCurrentWeatherFragmentToCityListFragment()
            navigationController.navigate(action)
        }

/*
        searchView?.setOnCloseListener(object : SearchView.OnCloseListener{
            override fun onClose(): Boolean {
                val action = CityListFragmentDirections.actionCityListFragmentToCurrentWeatherFragment("Aksaray")
                navigationController.navigate(action)

                return false
            }

        })

 */

        return super.onCreateOptionsMenu(menu)
    }


    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        setSupportActionBar(binding.toolbar)

        navigationController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this, navigationController)



    }

    override fun onSupportNavigateUp(): Boolean {

        return NavigationUI.navigateUp(navigationController, null)
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        var newCityList = arrayListOf<City>()
        for (city in cityList){
            if (city.name.toLowerCase().contains(newText?.toLowerCase().toString())){
                newCityList.add(city)
            }
        }

        currentWeatherAdapter.changeList(newCityList)
        currentWeatherAdapter.notifyDataSetChanged()

        return true
    }

    override fun onBackPressed() {
        if (!searchView?.isIconified!!) {
            searchView?.setIconified(true)
        } else {
            super.onBackPressed()
        }
    }

}




