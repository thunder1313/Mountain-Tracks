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
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Handler(Looper.getMainLooper()).postDelayed({
            Animation()
        }, 1500)
//        Animation()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val actionBar = findViewById<Toolbar>(R.id.action_bar)
        setSupportActionBar(actionBar)
        actionBar.title = getString(R.string.app_name)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val toggle =  ActionBarDrawerToggle(
            this,
            drawer,
            actionBar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawer.addDrawerListener(toggle)

        toggle.syncState()
    }

    fun onShowDetail(view: View) {
        val intent = Intent(applicationContext, DetailActivity::class.java);
        startActivity(intent);
    }

    fun Animation(){
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
    }}