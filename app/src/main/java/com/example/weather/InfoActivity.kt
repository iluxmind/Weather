package com.example.weather

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.weather.API.BASE_URL
import com.example.weather.API.WeatherService
import com.example.weather.Model.weather
import com.example.weather.ViewModel.InfoViewModel
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_info.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        progressBar.setVisibility(View.VISIBLE)
        //INTENT
        var strcity: String? = intent.getStringExtra("city")

        //RETROFIT SERVICE
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(WeatherService::class.java)

        //GETWEATHER
        service.getCurrentWeatherData("b0a19a145db85eb2d56a4057656f7aa1",strcity.toString()).enqueue(object :
            retrofit2.Callback<weather> {
            override fun onFailure(call: retrofit2.Call<weather>, t: Throwable) {
                //FAIL
                val t = Toast.makeText(this@InfoActivity, "No country !!", Toast.LENGTH_LONG)
                t.show()
                progressBar.setVisibility(View.INVISIBLE)

                //INTENT TO MAIN PAGE
                val intent = Intent(this@InfoActivity, MainActivity::class.java)
                startActivity(intent)
            }

            override fun onResponse(call: retrofit2.Call<weather>, response: Response<weather>) {
                //PASS
                val gson = Gson()
                val t: weather = gson.fromJson(Gson().toJson(response.body()), com.example.weather.Model.weather::class.java)

                //SET VALUE
                try{
                    city.text           = t.request.query.toString()
                    name.text           = t.location.name.toString()
                    temperature.text    = t.current.temperature.toString() + " ํC"
                    humidity.text       = t.current.humidity.toString() + "%"
                    pressure.text       = t.current.pressure.toString() + " mBar"
                    uv_index.text       = "igh, "+t.current.uv_index.toString()
                    wind_speed.text     = t.current.wind_speed.toString() + " km/h "+t.current.wind_dir.toString()

                    val imageUrl = t.current.weather_icons.get(0).toString()
                    Picasso.get().load(imageUrl).into(weather_icons)

                }catch (e:Exception){
                    Log.d("ddddddddddd","ERROR")
                    val intent = Intent(this@InfoActivity, MainActivity::class.java)
                    intent.putExtra("error", "Can't find this word. Try again")
                    startActivity(intent)
                }

                progressBar.setVisibility(View.INVISIBLE)

                //NAME CLICK TO MAP
                name.setOnClickListener{
                    val intent = Intent(this@InfoActivity, MapsActivity::class.java)
                    intent.putExtra("lat", t.location.lat)
                    intent.putExtra("lon", t.location.lon)
                    intent.putExtra("name", t.request.query)
                    startActivity(intent)
                }

            }

        })


    }
}

