package com.example.mountain

import android.animation.Animator
import android.animation.AnimatorListenerAdapter

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.viewpager.widget.ViewPager
import 	com.google.android.material.tabs.TabLayout
class MainActivity : AppCompatActivity()
    , NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Handler(Looper.getMainLooper()).postDelayed({
            animation()
        }, 1500)
//        Animation()

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

        val toggle =  ActionBarDrawerToggle(
            this,
            drawer,
            actionBar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawer.addDrawerListener(toggle)

        toggle.syncState()
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)



    }

    fun onShowDetail(view: View) {
        val intent = Intent(applicationContext, DetailActivity::class.java);
        startActivity(intent);
    }

    private fun animation(){
        val animationView = findViewById<ImageView>(R.id.start_animation)

        val spinAnimator = ObjectAnimator.ofFloat(animationView, "rotation", 0f, 360f)
        spinAnimator.duration = 2000 // 2 seconds for one rotation
        spinAnimator.repeatCount = ObjectAnimator.INFINITE
        spinAnimator.interpolator = AccelerateInterpolator()

        // Scale animation
        val scaleAnimatorX = ObjectAnimator.ofFloat(animationView, "scaleX", 1f, 0f)
        val scaleAnimatorY = ObjectAnimator.ofFloat(animationView, "scaleY", 1f, 0f)
        scaleAnimatorX.duration = 2000
        scaleAnimatorY.duration = 2000
        scaleAnimatorX.interpolator = AccelerateInterpolator()
        scaleAnimatorY.interpolator = AccelerateInterpolator()

        // Start both animations together
        spinAnimator.start()
        scaleAnimatorX.start()
        scaleAnimatorY.start()

        // Hide the imageView when animation ends
        spinAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                animationView.visibility = View.GONE
    }
})
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}