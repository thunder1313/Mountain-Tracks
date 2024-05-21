package com.example.mountain

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        // Get references to the UI elements
        val userPhoto: ImageView = findViewById(R.id.user_photo)
        val username: TextView = findViewById(R.id.username)
        val trackCount: TextView = findViewById(R.id.track_count)

        // Set the user photo (e.g., app logo or relevant image)
        userPhoto.setImageResource(R.drawable.ic_trails_to_discover) // Replace with actual photo resource

        // Calculate the number of tracks
        val numberOfTracks = Trail.trails.size + Trail.hardTrails.size
        trackCount.text = "Currently, there are $numberOfTracks tracks to discover!"
        username.text = "Welcome adventurer XYZ!"
    }
}
