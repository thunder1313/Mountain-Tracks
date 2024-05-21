package com.example.mountain

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import coil.load
import com.google.android.material.navigation.NavigationView

class DetailActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        val actionBar = findViewById<Toolbar>(R.id.action_bar)
        setSupportActionBar(actionBar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val fab = findViewById<View>(R.id.fab)
        fab.setOnClickListener {
            Toast.makeText(this, "Taking photo..." , Toast.LENGTH_SHORT).show();
        }

        val id = intent.getIntExtra("id", -1)
        val openedTab = intent.getIntExtra("tab", -1)

        val image = findViewById<ImageView>(R.id.image)
        if(openedTab == 1) {
            image.load(Trail.trails[id].thumbnail)
        } else {
            image.load(Trail.hardTrails[id].thumbnail)
        }

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

        if (id != -1) {
            val fragment = TrackDetailFragment.newInstance(id, openedTab)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.trackDetailFragment, fragment)
            transaction.commit()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        var intent: Intent? = null

        when (id) {
            R.id.drawer_home -> {
                intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("fragment", "home")
                    putExtra("tab", 0)
                }
            }
            R.id.drawer_easy -> {
                intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("fragment", "home")
                    putExtra("tab", 1)
                }
            }
            R.id.drawer_hard -> {
                intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("fragment", "home")
                    putExtra("tab", 2)
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