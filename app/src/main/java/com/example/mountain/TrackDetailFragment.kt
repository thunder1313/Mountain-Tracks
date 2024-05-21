package com.example.mountain

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import coil.load

class TrackDetailFragment : Fragment() {
    private var trackID: Int? = null
    private var tab: Int? = null
    private var trail: Trail? = null

    private lateinit var stopperFragment: StopperFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            trackID = it.getInt(ARG_ID)
            tab = it.getInt(ARG_TAB)
            trail = when(tab) {
                1 -> Trail.trails.firstOrNull { it.id == trackID } ?: Trail.trails[0]
                else -> Trail.hardTrails.firstOrNull { it.id == trackID } ?: Trail.hardTrails[0]
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_track_detail, container, false)

        val nameTextView = view.findViewById<TextView>(R.id.trackName)
        val descriptionTextView = view.findViewById<TextView>(R.id.trackDescription)
        val pointsListView = view.findViewById<ListView>(R.id.trackList)


        nameTextView.text = trail?.name
        descriptionTextView.text = trail?.description


        val adapter = ArrayAdapter(inflater.context, android.R.layout.simple_list_item_1, trail?.points ?: arrayOf())
        pointsListView.adapter = adapter

        stopperFragment = StopperFragment()
        stopperFragment.setTrack(trail)
        childFragmentManager.beginTransaction()
            .replace(R.id.stopper_container, stopperFragment)
            .commit()
        return view
    }

    companion object {
        private const val ARG_ID = "id"
        private const val ARG_TAB = "tabOpened"

        fun newInstance(id: Int, tabOpened: Int) = TrackDetailFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_ID, id)
                putInt(ARG_TAB, tabOpened)
            }
        }
    }
}