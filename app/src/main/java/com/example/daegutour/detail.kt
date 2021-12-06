package com.example.daegutour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class detail : AppCompatActivity() {
    lateinit var datas : ListData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        datas = intent.getParcelableExtra<ListData>("data") as ListData
        Glide.with(this).load(datas.img).into(img)
        name.text = datas.name
        address.text = datas.address
        desc.text = datas.desc
    }
}