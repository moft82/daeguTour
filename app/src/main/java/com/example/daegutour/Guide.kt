package com.example.daegutour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Guide : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        val imgBack = findViewById<ImageView>(R.id.BackBtnImage)

        imgBack.setOnClickListener {
            this.onBackPressed()
        }
    }
}