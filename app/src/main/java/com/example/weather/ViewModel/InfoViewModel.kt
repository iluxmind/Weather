package com.example.weather.ViewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.API.BASE_URL
import com.example.weather.API.WeatherService
import com.example.weather.Model.weather
import com.google.gson.Gson
import io.reactivex.disposables.Disposable
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class InfoViewModel : ViewModel() {
//    private var weather = MutableLiveData<weather>()
//
//    fun fetchWeather(Search : String) {
//
//        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
//        val service = retrofit.create(WeatherService::class.java)
//        service.getCurrentWeatherData("b0a19a145db85eb2d56a4057656f7aa1",Search).enqueue(object :
//            retrofit2.Callback<weather> {
//            override fun onFailure(call: retrofit2.Call<weather>, t: Throwable) {
//                Log.d("FAIL :: ","${t}")
//            }
//            override fun onResponse(call: retrofit2.Call<weather>, response: Response<weather>) {
//                val gson = Gson()
//                val t: weather = gson.fromJson(Gson().toJson(response.body()), com.example.weather.Model.weather::class.java)
//
//            }
//
//        })
//    }
}