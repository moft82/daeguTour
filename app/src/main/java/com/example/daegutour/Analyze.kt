package com.example.daegutour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_analyze.*


class Analyze : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyze)

        // Get intent Extra
        val intent = intent
        val data = intent.getParcelableExtra<ListData>("data") as ListData

        // Set data to Layout
        name.text = data.name
        avg_rate.text = data.avg
        google_rate.text = data.google
        naver_rate.text = data.naver
        trip_rate.text = data.trip
        Glide.with(this).load(data.wordCloud).into(img)
    }
}