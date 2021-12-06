package com.example.daegutour

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity() : AppCompatActivity() {
    private lateinit var mContext : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun TourSpot(view: View) {
        val intent : Intent = Intent(this, TourSpot::class.java)
        startActivity(intent)
    }

    fun Restaurant(view: View){
        val intent : Intent = Intent(this, Restaurant::class.java)
        startActivity(intent)
    }

}
