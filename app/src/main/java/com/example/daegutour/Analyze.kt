package com.example.daegutour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Analyze : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyze)

        // Get intent Extra
        val intent = intent
        val name = intent.getStringExtra("name")
    }
}