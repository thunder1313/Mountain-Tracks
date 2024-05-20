package com.example.mountain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class StatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_stats, container, false)

        // Get references to the UI elements
        val userPhoto: ImageView = view.findViewById(R.id.user_photo)
        val username: TextView = view.findViewById(R.id.username)
        val trackCount: TextView = view.findViewById(R.id.track_count)

        // Set the user photo (e.g., app logo or relevant image)
        userPhoto.setImageResource(R.drawable.ic_trails_to_discover) // Replace with actual photo resource

        // Calculate the number of tracks
        val numberOfTracks = Trail.trails.size
        trackCount.text = "Currently, there are $numberOfTracks tracks to discover!"
        username.text = "Welcome adventurer! Pack up, XYZ!"

        return view
    }
}
