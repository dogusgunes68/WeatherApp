package com.example.weatherappwithmvvm.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.weatherappwithmvvm.R
import com.example.weatherappwithmvvm.adapter.CurrentWeatherRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {


    private var cityList = arrayListOf("Ankara", "İstanbul", "İzmir")

    private var currentWeatherRecyclerViewAdapter : CurrentWeatherRecyclerViewAdapter? = null
    private lateinit var navigationController : NavController

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater : MenuInflater = menuInflater

            menuInflater.inflate(R.menu.toolbar_menu, menu)

            val searchItem = menu?.findItem(R.id.action_search)
            val searchView = searchItem?.actionView as SearchView

        searchView.setOnQueryTextListener(this)

        searchView.setOnSearchClickListener{

            val action = CurrentWeatherFragmentDirections.actionCurrentWeatherFragmentToCityListFragment()
            navigationController.navigate(action)
        }

        return super.onCreateOptionsMenu(menu)
    }


    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(toolbar)

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




