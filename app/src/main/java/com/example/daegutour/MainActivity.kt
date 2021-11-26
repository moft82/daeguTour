package com.example.daegutour

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_tab_button.view.*



class MainActivity() : AppCompatActivity() {
    private lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = applicationContext
        initViewPager()

    }
    private fun createView(tabName: String): View {
        var tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab_button, null)

        tabView.tab_text.text = tabName
        // Set Icon image
        when (tabName) {
            "Home" -> {
                tabView.tab_logo.setImageResource(R.drawable.tour)
                return tabView
            }
            "Spot" -> {
                tabView.tab_logo.setImageResource(android.R.drawable.ic_menu_myplaces)
                return tabView
            }
            "Restaurant" -> {
                tabView.tab_logo.setImageResource(android.R.drawable.ic_menu_view)
                return tabView
            }
            "Facility" -> {
                tabView.tab_logo.setImageResource(android.R.drawable.ic_menu_view)
                return tabView
            }
            else -> {
                return tabView
            }
        }
    }
    private fun initViewPager(){
        // Fragments
        val homeFragment = HomeFragmentTab()
        homeFragment.name = "Home"
        val spotFragment = SpotFragmentTab()
        spotFragment.name = "Spot"
        val restaurantFragmentTab = RestaurantFragmentTab()
        restaurantFragmentTab.name = "Restaurant"
        val facilityFragmentTab = FacilityFragmentTab()
        facilityFragmentTab.name = "Facility"

        // Page Adapter
        val adapter = PageAdapter(supportFragmentManager)
        adapter.addItems(homeFragment)
        adapter.addItems(spotFragment)
        adapter.addItems(restaurantFragmentTab)
        adapter.addItems(facilityFragmentTab)

        main_viewPager.adapter = adapter // 뷰페이저에 adapter 장착
        main_tablayout.setupWithViewPager(main_viewPager) // 탭레이아웃과 뷰페이저를 연동


        main_tablayout.getTabAt(0)?.setCustomView(createView("Home"))
        main_tablayout.getTabAt(1)?.setCustomView(createView("Spot"))
        main_tablayout.getTabAt(2)?.setCustomView(createView("Restaurant"))
        main_tablayout.getTabAt(3)?.setCustomView(createView("Facility"))

    }



}
