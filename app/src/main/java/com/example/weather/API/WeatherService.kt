package com.example.weather.API

import com.example.weather.Model.weather
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
const val BASE_URL = "http://api.weatherstack.com/"
interface WeatherService {
    @GET("current?")
    fun getCurrentWeatherData(@Query("access_key") access_key: String,@Query("query") query:String): Call<weather>
}