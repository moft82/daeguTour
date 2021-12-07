package com.example.daegutour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun tourSpot() {
        val intent = Intent(this, TourSpot::class.java)
        startActivity(intent)
    }

    fun restaurant(){
        val intent = Intent(this, Restaurant::class.java)
        startActivity(intent)
    }

}
