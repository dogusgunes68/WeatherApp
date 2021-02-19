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
import com.example.weatherappwithmvvm.databinding.ActivityMainBinding

var searchView : SearchView? = null

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
                val action = CurrentWeatherFragmentDirections.actionCurrentWeatherFragmentToCityListFragment()
                navigationController.navigate(action)
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {

                val action = CityListFragmentDirections.actionCityListFragmentToCurrentWeatherFragment()
                navigationController.navigate(action)
                return true
            }
        })

        /*
        searchView.setOnSearchClickListener {
            val action = CurrentWeatherFragmentDirections.actionCurrentWeatherFragmentToCityListFragment()
            navigationController.navigate(action)
        }

         */

        searchView?.setOnClickListener {
            val action = CurrentWeatherFragmentDirections.actionCurrentWeatherFragmentToCityListFragment()
            navigationController.navigate(action)
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        if (!searchView!!.isIconified){
            searchView!!.isIconified = true

        }else{
            super.onBackPressed()
        }

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



        return true
    }


}




