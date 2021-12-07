package com.example.daegutour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class Facility : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facility)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        // Get intent Extra
        val intent = intent
        val name = intent.getStringExtra("name")
        val latitude = intent.getFloatExtra("latitude", 35.0f)
        val longitude = intent.getFloatExtra("longitude", 35.0f)


        mMap = googleMap

        // Data Load
        val csvReader = CsvReader()
        val toilet = csvReader.readCSVToilet(resources.openRawResource(R.raw.toilet))
        val tourGuide = csvReader.readCSVTourguide(resources.openRawResource(R.raw.tour_guide))
        val wifi = csvReader.readCSVWifi(resources.openRawResource(R.raw.wifi))

        // Add Marker
        val toiletMarker = addMarker(toilet, BitmapDescriptorFactory.HUE_GREEN, mMap)
        val tourGuideMarker = addMarker(tourGuide, BitmapDescriptorFactory.HUE_BLUE, mMap)
        val wifiMarker = addMarker(wifi, BitmapDescriptorFactory.HUE_YELLOW, mMap)

        // Add Spot Marker and move Camera
        val spot = LatLng(latitude.toDouble(), longitude.toDouble())
        mMap.addMarker(MarkerOptions().position(spot).title(name))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(spot, 17f))

        // Switch Set
        val switchToilet = findViewById<Switch>(R.id.toilet_switch)
        val switchTourGuide = findViewById<Switch>(R.id.tourguide_switch)
        val switchWifi = findViewById<Switch>(R.id.wifi_switch)
        switchToilet.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) markerVisibleSet(toiletMarker, mMap, true)
            else markerVisibleSet(toiletMarker, mMap, false)
        }
        switchTourGuide.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) markerVisibleSet(tourGuideMarker, mMap, true)
            else markerVisibleSet(tourGuideMarker, mMap, false)
        }
        switchWifi.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) markerVisibleSet(wifiMarker, mMap, true)
            else markerVisibleSet(wifiMarker, mMap, false)
        }


    }

    private fun addMarker(data:List<Map<String, String>>, color: Float, mMap:GoogleMap): MutableList<Marker> {
        Log.d("Marker", "Start")
        val dataIterator = data.iterator()
        val markers:MutableList<Marker> = mutableListOf<Marker>()
        while (dataIterator.hasNext()) {
            val tokens = dataIterator.next()
            val position = LatLng(tokens["latitude"]!!.toDouble(), tokens["longitude"]!!.toDouble())
            markers.add(mMap.addMarker(MarkerOptions().position(position)
                .title(tokens["name"].toString())
                .icon(BitmapDescriptorFactory.defaultMarker(color)))
            )
        }
        Log.d("Marker", "Done")
        return markers
    }
    fun markerVisibleSet(markers:List<Marker>, mMap: GoogleMap, is_visible:Boolean){
        val markerIterator = markers.iterator()
        while (markerIterator.hasNext()) {
            val marker = markerIterator.next()
            marker.isVisible = is_visible
        }
    }
}