package com.example.daegutour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TourSpot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tour_spot)

        // Set Button
        val button1 = findViewById<Button>(R.id.tour_culture)
        val button2 = findViewById<Button>(R.id.tour_history)
        val button3 = findViewById<Button>(R.id.tour_shop)
        val button4 = findViewById<Button>(R.id.tour_nature)

        // Set OnClickListener
        button1.setOnClickListener{
            toList(ins = R.raw.tour_culture)
        }
        button2.setOnClickListener{
            toList(ins =R.raw.tour_history)
        }
        button3.setOnClickListener{
            toList(ins  =R.raw.tour_shop)
        }
        button4.setOnClickListener{
            toList(ins = R.raw.tour_nature)
        }
    }

    private fun toList(ins: Int) {
        val intent: Intent = Intent(this, ListView::class.java)
        intent.putExtra("fname", ins)
        startActivity(intent)
    }
}