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
        
        Handler(Looper.getMainLooper()).postDelayed({animation()}, 1500)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val pagerAdapter = PagerAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.pager)

        if (pager!=null){
        pager.adapter = pagerAdapter
        val tabLayout  = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(pager)}

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

    private fun animation() {

        val animationView = findViewById<ImageView>(R.id.start_animation)
        animationView.visibility = View.VISIBLE

        val spinAnimator = ObjectAnimator.ofFloat(animationView, "rotation", 0f, 360f).apply {
            duration = 2000 // 2 seconds for one rotation
            repeatCount = ObjectAnimator.INFINITE
            interpolator = AccelerateInterpolator()
        }

        val scaleAnimatorX = ObjectAnimator.ofFloat(animationView, "scaleX", 1f, 0f).apply {
            duration = 2000
            interpolator = AccelerateInterpolator()
        }

        val scaleAnimatorY = ObjectAnimator.ofFloat(animationView, "scaleY", 1f, 0f).apply {
            duration = 2000
            interpolator = AccelerateInterpolator()
        }

        spinAnimator.start()
        scaleAnimatorX.start()
        scaleAnimatorY.start()

        spinAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                animationView.visibility = View.GONE
            }
        })
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        var fragment: Fragment? = null
        var intent: Intent? = null

        when (id) {
            R.id.drawer_home -> fragment = TrackListFragment()
            R.id.drawer_option1 -> fragment = StatsFragment()
        }

        if (fragment != null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.list_frag, fragment)
            ft.commit()
        } else if (intent != null) {
            startActivity(intent)
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

}
