package com.example.daegutour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_list_view.*


class list_view : AppCompatActivity() {
    lateinit var recycleAdapter: RecycleAdapter
    val datas = mutableListOf<ListData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // Get CSV File Name
        var intent = getIntent()
        var fname = intent.getIntExtra("fname", R.raw.tour_history)

        // Read CSV
        val csvReader = CsvReader()
        val sopts = csvReader.readListData(resources.openRawResource(fname))
        intiRecycler(sopts)

    }
    private fun intiRecycler(data : List<Map<String, String>>){
        val recycleAdapter = RecycleAdapter(this)
        recycle.adapter = recycleAdapter
        val dataIterator = data.iterator()
        datas.apply{
            while(dataIterator.hasNext()){
                var tokens = dataIterator.next()
                var img = getResources().getIdentifier(tokens["fname"].toString(), "drawable", packageName)
                add(
                    ListData(
                        img= img,
                        address = tokens["address"].toString(),
                        name=tokens["name"].toString(),
                        desc=tokens["desc"].toString(),
                        latitude= (tokens["latitude"] ?: error("")).toFloat(),
                        longitude= (tokens["longitude"] ?: error("")).toFloat()
                    )
                )
            }
            recycleAdapter.datas = datas
            recycleAdapter.notifyDataSetChanged()
        }
        recycleAdapter.setOnItemClickListener(object : RecycleAdapter.OnItemClickListener{
            override fun onItemClick(v: View, data: ListData, pos : Int) {
                Intent(this@list_view, detail::class.java).apply {
                    putExtra("data", data)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
            }

        })
    }
}

