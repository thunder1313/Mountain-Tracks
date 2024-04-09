package com.example.mountain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [TrackDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrackDetailFragment : Fragment() {
    private var trackID: Int = 0
    fun setTrack(id: Int) {
        this.trackID = id
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_track_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        val view: View? = getView()
        val title: TextView? = view?.findViewById(R.id.textTitle) as TextView?
        val details: TextView? = view?.findViewById((R.id.textDetails)) as TextView?
        val track: Track = Track.tracks[trackID]
        title?.setText(track.getName())
        details?.setText(track.getDetails())
    }
}