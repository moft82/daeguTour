package com.example.daegutour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class TourSpot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tour_spot)


        val cardHistory = findViewById<CardView>(R.id.tour_history)
        val cardCulture = findViewById<CardView>(R.id.tour_culture)
        val cardShop = findViewById<CardView>(R.id.tour_shop)
        val cardNature = findViewById<CardView>(R.id.tour_nature)


        // Set OnClickListener
        cardCulture.setOnClickListener{
            toList(ins = R.raw.tour_culture)
        }
        cardHistory.setOnClickListener{
            toList(ins = R.raw.tour_history)
        }
        cardShop.setOnClickListener{
            toList(ins =R.raw.tour_shop)
        }
        cardNature.setOnClickListener{
            toList(ins = R.raw.tour_nature)
        }
    }

    private fun toList(ins: Int) {
        val intent: Intent = Intent(this, ListView::class.java)
        intent.putExtra("fileName", ins)
        startActivity(intent)
    }
}