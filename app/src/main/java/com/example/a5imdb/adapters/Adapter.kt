package com.example.a5imdb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a5imdb.R
import com.example.a5imdb.classes.Movie


class MoviesAdapter(private val dataList: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    // this class creates objects with 1 property extending from the Recycler.ViewHolder
    //this class will be used after to create a viewHolder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText : TextView = itemView.findViewById(R.id.title)
        val yearText : TextView = itemView.findViewById(R.id.year)
        val castingText : TextView = itemView.findViewById(R.id.casting)
        val image : ImageView = itemView.findViewById(R.id.movieImage)
    }

    //when we need to create a ViewHolder:
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return ViewHolder(view)
    }

    // here is where the ViewHolder is update with the info
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = dataList[position]

        // we need permission to do internet stuff
        Glide.with(holder.itemView.context).load(currentItem.img).into(holder.image)

        holder.titleText.text = currentItem.title
        holder.yearText.text = currentItem.year.toString()
        holder.castingText.text = currentItem.actors.joinToString(", ")

    }

    //why is this important?
    override fun getItemCount(): Int {
        return dataList.size
    }
}
