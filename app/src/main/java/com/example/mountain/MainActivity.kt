package com.example.mountain

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import androidx.viewpager.widget.ViewPager
import 	com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Handle extras from DetailActivity
        val tabToOpen = intent.getIntExtra("tab", 0) // Default to the first tab

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pagerAdapter = PagerAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.pager)

        if (pager != null) {
            pager.adapter = pagerAdapter
            val tabLayout = findViewById<TabLayout>(R.id.tabs)
            tabLayout.setupWithViewPager(pager)
            // Select the tab passed from DetailActivity
            tabLayout.getTabAt(tabToOpen)?.select()
        }

        val actionBar = findViewById<Toolbar>(R.id.action_bar)
        setSupportActionBar(actionBar)
        actionBar.title = getString(R.string.app_name)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawer, actionBar,
            R.string.open_drawer, R.string.close_drawer
        )

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    private fun switchToTab(tabIndex: Int) {
        val pager = findViewById<ViewPager>(R.id.pager)
        pager.currentItem = tabIndex
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        var fragment: Fragment? = null
        var intent: Intent? = null

        when (id) {
            R.id.drawer_home -> switchToTab(0) // Switch to Welcome tab
            R.id.drawer_easy -> switchToTab(1) // Switch to Easy Tracks tab
            R.id.drawer_hard -> switchToTab(2) // Switch to Hard Tracks tab
            R.id.drawer_option1 -> intent = Intent(this, StatsActivity::class.java)
        }

        if (intent != null) {
            startActivity(intent)
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
