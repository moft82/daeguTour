package com.example.daegutour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class Detail : AppCompatActivity() {
    private lateinit var datas : ListData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        datas = intent.getParcelableExtra<ListData>("data") as ListData

        // Set values in layout
        Glide.with(this).load(datas.img).into(img)
        name.text = datas.name
        address.text = datas.address
        desc.text = datas.desc

        // Button OnClickListener
        val buttonAnalyze = findViewById<Button>(R.id.analyze)
        val buttonFacility = findViewById<Button>(R.id.facility)
        val imgBack = findViewById<ImageView>(R.id.BackBtnImage)

        imgBack.setOnClickListener {
            this.onBackPressed()
        }

        buttonAnalyze.setOnClickListener{
            toAnalyze(name = datas.name,
                data = datas
            )
        }
        buttonFacility.setOnClickListener{
            toFacility(name = datas.name,
                latitude = datas.latitude,
                longitude = datas.longitude
            )
        }

    }


    private fun toAnalyze(name: String, data:ListData) {
        val intent = Intent(this, Analyze::class.java)
        intent.putExtra("name", name)
        intent.putExtra("data", data)
        startActivity(intent)
    }


    private fun toFacility(name : String, latitude : Float, longitude : Float) {
        val intent = Intent(this, Facility::class.java)
        intent.putExtra("name", name)
        intent.putExtra("latitude", latitude)
        intent.putExtra("longitude", longitude)
        startActivity(intent)
    }
}