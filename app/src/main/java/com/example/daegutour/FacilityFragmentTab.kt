package com.example.daegutour

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_facility.view.*
import java.io.InputStream

class FacilityFragmentTab : Fragment() {
    var name = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_home, container, false)
        view.textView.text = name
        val csvReader = CsvReader()
        val wifi = csvReader.readCSVWifi(getResources().openRawResource(R.raw.wifi))
        val toilet = csvReader.readCSVToilet(getResources().openRawResource(R.raw.toilet))
        val tourGuide = csvReader.readCSVTourguide(getResources().openRawResource(R.raw.tour_guide))
        Log.d("dataRead", wifi[0]["name"].toString())
        return view
    }


}