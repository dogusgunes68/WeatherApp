package com.example.weatherappwithmvvm.model

import com.google.gson.annotations.SerializedName

data class City (@SerializedName("name") val name : String,
                 @SerializedName("countryName") val countryName : String,
                 @SerializedName("countryCode") val countryCode : String
            ){

}