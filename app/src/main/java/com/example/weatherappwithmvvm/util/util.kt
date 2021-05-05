package com.example.weatherappwithmvvm.util

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.weatherappwithmvvm.R

fun ConstraintLayout.addBackroundImage(weatherType : String?,layout : ConstraintLayout?){
    if (weatherType?.toLowerCase().equals("clouds")){
        layout?.setBackgroundResource(R.drawable.cloudy)
    }

    if (weatherType?.toLowerCase().equals("clear")){
        layout?.setBackgroundResource(R.drawable.sunny)
    }
    if (weatherType?.toLowerCase().equals("rain")){
        layout?.setBackgroundResource(R.drawable.rainy)
    }
    if (weatherType?.toLowerCase().equals("snow")){
        layout?.setBackgroundResource(R.drawable.snowy)
    }
    if (weatherType?.toLowerCase().equals("wind")){
        layout?.setBackgroundResource(R.drawable.windy)
    }
 
}