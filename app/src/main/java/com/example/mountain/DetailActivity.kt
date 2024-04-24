package com.example.mountain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_detail)
        val id = intent.getIntExtra("id", -1)
        if (id != -1) {
            val fragment = TrackDetailFragment.newInstance(id)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.trackDetailFragment, fragment)
            transaction.commit()
        }
    }
}