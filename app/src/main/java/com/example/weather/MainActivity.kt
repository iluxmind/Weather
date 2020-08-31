package com.example.weather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.weather.ViewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try{
            var error: String? = intent.getStringExtra("error")

            if(error == null){

            }else{
                val t = Toast.makeText(this@MainActivity, "${error}", Toast.LENGTH_LONG)
                t.show()
            }

        }catch (e:Exception){

        }
        //BUTTON SEARCH
        find.setOnClickListener{
            if (city.text!!.isNotEmpty()) {
                //GO TO INFO PAGE
                val intent = Intent(this, InfoActivity::class.java)
                intent.putExtra("city", city.text.toString())
                startActivity(intent)
            }
            else{
                //ALERT WARNING
                val t = Toast.makeText(this@MainActivity,  "Please Input city", Toast.LENGTH_LONG)
                t. show()
            }
        }
    }
}