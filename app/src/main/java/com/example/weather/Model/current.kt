package com.example.weather.Model

import com.google.gson.annotations.SerializedName

class current (
    @SerializedName("cloudcover")
    val cloudcover: String,
    @SerializedName("feelslike")
    val feelslike: String,
    @SerializedName("humidity")
    val humidity: String,
    @SerializedName("is_day")
    val is_day: String,
    @SerializedName("observation_time")
    val observation_time: String,
    @SerializedName("precip")
    val precip: String,
    @SerializedName("pressure")
    val pressure: String,
    @SerializedName("temperature")
    val temperature: String,
    @SerializedName("uv_index")
    val uv_index: String,
    @SerializedName("visibility")
    val visibility: String,
    @SerializedName("weather_code")
    val weather_code: String,
    @SerializedName("weather_descriptions")
    val weather_descriptions: List<String>,
    @SerializedName("weather_icons")
    val weather_icons: List<String>,
    @SerializedName("wind_degree")
    val wind_degree: String,
    @SerializedName("wind_dir")
    val wind_dir: String,
    @SerializedName("wind_speed")
    val wind_speed: String
)