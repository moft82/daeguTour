package com.example.daegutour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_list_view.*


class ListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // Get CSV File Name
        val intent = intent
        val fileName = intent.getIntExtra("fileName", R.raw.tour_history)

        // Read CSV
        val csvReader = CsvReader()
        val data = csvReader.readListData(resources.openRawResource(fileName))

        // Init Recycler
        intiRecycler(data = data)
    }

    private fun intiRecycler(data: List<Map<String, String>>) {
        val datas = mutableListOf<ListData>()
        val recycleAdapter = RecycleAdapter(this)
        recycle.adapter = recycleAdapter

        // Set Data Iterator
        val dataIterator = data.iterator()

        // Set Data
        datas.apply {
            while (dataIterator.hasNext()) {
                val tokens = dataIterator.next()
                val img =
                    resources.getIdentifier(tokens["fname"].toString(), "drawable", packageName)
                add(
                    ListData(
                        img = img,
                        address = tokens["address"].toString(),
                        name = tokens["name"].toString(),
                        desc = tokens["desc"].toString(),
                        latitude = (tokens["latitude"] ?: error("")).toFloat(),
                        longitude = (tokens["longitude"] ?: error("")).toFloat()
                    )
                )
            }
            recycleAdapter.datas = datas
            recycleAdapter.notifyDataSetChanged()
        }

        // Set ClickListener
        recycleAdapter.setOnItemClickListener(
            object : RecycleAdapter.OnItemClickListener {
                override fun onItemClick(v: View, data: ListData, pos: Int) {
                    Intent(this@ListView, Detail::class.java).apply {
                        putExtra("data", data)
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }.run { startActivity(this) }
                }

            }
        )
    }
}

