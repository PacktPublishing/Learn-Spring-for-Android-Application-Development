package com.sunnat629.clientside

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.sunnat629.clientside.ui.fragment.DashboardFragment
import com.sunnat629.clientside.ui.fragment.HomeFragment
import com.sunnat629.clientside.ui.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    val homeFragment: Fragment = HomeFragment()
    val dashboardFragment: Fragment = DashboardFragment()
    val profileFragment: Fragment = ProfileFragment()

    val fm = supportFragmentManager
    var activeFragment = homeFragment

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fm.beginTransaction().hide(activeFragment).show(homeFragment).commit();
                activeFragment = homeFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                fm.beginTransaction().hide(activeFragment).show(dashboardFragment).commit();
                activeFragment = dashboardFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                fm.beginTransaction().hide(activeFragment).show(profileFragment).commit();
                activeFragment = profileFragment
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setTitleName()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        fm.beginTransaction().add(R.id.main_container,homeFragment, "1").commit()
        fm.beginTransaction().add(R.id.main_container, dashboardFragment, "2").hide(dashboardFragment).commit()
        fm.beginTransaction().add(R.id.main_container, profileFragment, "3").hide(profileFragment).commit()
    }

    private fun setTitleName() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)
    }
}
