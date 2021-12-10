package com.example.daegutour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun tourSpot(view : View) {
        val intent = Intent(this, TourSpot::class.java)
        startActivity(intent)
    }

    fun guide(view : View) {
        val intent = Intent(this, Guide::class.java)
        startActivity(intent)
    }
}
