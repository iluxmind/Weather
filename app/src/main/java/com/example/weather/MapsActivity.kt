package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        var lat: String? = intent.getStringExtra("lat")
        var lon: String? = intent.getStringExtra("lon")
        var name: String? = intent.getStringExtra("name")
        val mark = LatLng(lat!!.toDouble(), lon!!.toDouble())
        mMap.addMarker(MarkerOptions().position(mark).title("Marker in ${name}"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mark))
    }
}