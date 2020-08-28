package com.example.weather.Model

import com.google.gson.annotations.SerializedName

class weather  (
    @SerializedName("current")
    val current: current,
    @SerializedName("location")
    val location: location,
    @SerializedName("request")
    val request: request
)