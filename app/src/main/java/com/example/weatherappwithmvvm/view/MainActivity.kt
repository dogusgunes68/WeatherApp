package com.example.weatherappwithmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import com.example.weatherappwithmvvm.R
import com.example.weatherappwithmvvm.databinding.FragmentCurrentWheatherBinding

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private var toolbar : Toolbar? = null

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val searchItem = menu?.findItem(R.id.search)
        val searchView = searchItem?.actionView as SearchView

        // Configure the search info and add any event listeners...

        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("Not yet implemented")
    }
}