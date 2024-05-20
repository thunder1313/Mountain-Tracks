package com.example.mountain

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        private const val PREFS_NAME = "MountainAppPrefs"
        private const val KEY_ANIMATION_SHOWN = "animation_shown"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Check if the animation has already been shown
        if (isAnimationShown()) {
            Handler(Looper.getMainLooper()).postDelayed({
                animation()
            }, 1500)
            setAnimationShown(false) // Set the flag immediately after starting the animation
        } else {
            // Hide the animation view if it has already been shown
            findViewById<ImageView>(R.id.start_animation).visibility = View.GONE
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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

        handleIntent(intent) // Handle the intent if the activity is started with an intent
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        val fragmentTag = intent.getStringExtra("fragment")
        var fragment: Fragment? = null

        when (fragmentTag) {
            "home" -> fragment = TrackListFragment()
            "stats" -> fragment = StatsFragment()
            // Handle other fragment tags as needed
        }

        if (fragment != null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.list_frag, fragment)
            ft.commit()
        }
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

    private fun isAnimationShown(): Boolean {
        val preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return preferences.getBoolean(KEY_ANIMATION_SHOWN, false)
    }

    private fun setAnimationShown(shown: Boolean) {
        val preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        preferences.edit().putBoolean(KEY_ANIMATION_SHOWN, shown).apply()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        var intent: Intent? = null

        when (id) {
            R.id.drawer_home -> {
                intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("fragment", "home")
                }
            }
            R.id.drawer_option1 -> {
                intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("fragment", "stats")
                }
            }
            // Add other cases as needed
        }

        intent?.let {
            startActivity(it)
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
