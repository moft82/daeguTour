package com.example.daegutour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class TourSpot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tour_spot)

        val button1 = findViewById<Button>(R.id.tour_culture)
        val button2 = findViewById<Button>(R.id.tour_history)
        val button3 = findViewById<Button>(R.id.tour_shop)
        val button4 = findViewById<Button>(R.id.tour_nature)

        button1.setOnClickListener{
            Log.d("ButtonClicked", "button1")
            ToList(type = R.raw.tour_culture)
        }
        button2.setOnClickListener{
            Log.d("ButtonClicked", "button2")
            ToList(type =R.raw.tour_history)
        }
        button3.setOnClickListener{
            Log.d("ButtonClicked", "button3")
            ToList(type =R.raw.tour_shop)
        }
        button4.setOnClickListener{
            Log.d("ButtonClicked", "button4")
            ToList(type =R.raw.tour_nature)
        }
    }

    fun ToList(type: Int) {
        val intent: Intent = Intent(this, list_view::class.java)
        intent.putExtra("fname", type)
        startActivity(intent)
    }
}