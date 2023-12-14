package com.example.a5imdb.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a5imdb.R

class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleText : TextView = itemView.findViewById(R.id.title)
    val yearText : TextView = itemView.findViewById(R.id.year)
    val castingText : TextView = itemView.findViewById(R.id.casting)
    val image : ImageView = itemView.findViewById(R.id.movieImage)
}