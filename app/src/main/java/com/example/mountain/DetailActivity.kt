package com.example.mountain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        val actionBar = findViewById<Toolbar>(R.id.action_bar_detail)
        setSupportActionBar(actionBar)
        actionBar.title = getString(R.string.app_name)

        val id = intent.getIntExtra("id", -1)
        if (id != -1) {
            val fragment = TrackDetailFragment.newInstance(id)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.trackDetailFragment, fragment)
            transaction.commit()
        }
    }
}