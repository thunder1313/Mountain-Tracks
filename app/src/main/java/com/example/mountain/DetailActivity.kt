package com.example.mountain

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import coil.load
import com.google.android.material.navigation.NavigationView

class DetailActivity : AppCompatActivity() {
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

        val image = findViewById<ImageView>(R.id.image)
        image.load(Trail.trails[id].thumbnail)

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

        if (id != -1) {
            val fragment = TrackDetailFragment.newInstance(id)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.trackDetailFragment, fragment)
            transaction.commit()
        }
    }
}