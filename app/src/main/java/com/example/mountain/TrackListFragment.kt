package com.example.mountain

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TrackListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var openedTabID: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            openedTabID = it.getInt(ARG_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val adapter = when (openedTabID) {
            1 -> CustomAdapter(Trail.trails)
            else -> CustomAdapter(Trail.hardTrails)
        }
        //val adapter = CustomAdapter(Trail.trails)


        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object :
            CustomAdapter.OnClickListener {
            override fun onClick(position: Int, model: Trail) {
                onListItemClicked(position, inflater)
            }
        })

        return view
    }

    private fun onListItemClicked(position: Int, inflater: LayoutInflater) {
        val detailContainer = activity?.findViewById<View>(R.id.detail_container)
        if (detailContainer != null) {
            swapDetailFragment(position)
        } else {
            openNewFragment(position, inflater)
        }
    }

    // Handles tablet layout
    private fun swapDetailFragment(position: Int) {
        val trail = Trail.trails[position]
        val detailFragment = TrackDetailFragment.newInstance(trail.id, 1)

        val transaction2 = requireActivity().supportFragmentManager.beginTransaction()
        transaction2.replace(R.id.detail_container, detailFragment)

        // Add stack entry to handle going back to previous details
        transaction2.addToBackStack(null)
        transaction2.commit()
    }

    // Handles phone layout
    private fun openNewFragment(position: Int, inflater: LayoutInflater) {
        //val trail = Trail.trails[position]
        val intent = Intent(inflater.context, DetailActivity::class.java)
        intent.putExtra("id", position)
        intent.putExtra("tab", openedTabID)
        startActivity(intent)
    }

    companion object {
        private const val ARG_ID = "id"
        fun newInstance(id: Int) = TrackListFragment().apply {
            arguments = Bundle().apply {
                putInt(TrackListFragment.ARG_ID, id)
            }
        }
    }
}