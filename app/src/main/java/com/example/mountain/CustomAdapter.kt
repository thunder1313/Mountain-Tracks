package com.example.mountain

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load


class CustomAdapter(private val dataSet: Array<Trail>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView
        var nameView: TextView

        init {
            imageView = itemView.findViewById(R.id.image)
            nameView = itemView.findViewById(R.id.name)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_element, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.nameView.text = dataSet[position].name
        viewHolder.imageView.load(dataSet[position].thumbnail)

        viewHolder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, dataSet[position] )
            }
        }
    }

    override fun getItemCount() = dataSet.size

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Trail)
    }

}