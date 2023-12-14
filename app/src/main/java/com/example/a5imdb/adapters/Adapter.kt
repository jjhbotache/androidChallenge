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
import com.example.a5imdb.model.MovieModel
import com.example.a5imdb.viewHolders.MoviesViewHolder


class MoviesAdapter(private val dataList: List<MovieModel>) : RecyclerView.Adapter<MoviesViewHolder>() {



    //when we need to create a ViewHolder:
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return MoviesViewHolder(view)
    }

    // here is where the ViewHolder is update with the info
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        val currentItem = dataList[position]

        // we need permission to do internet stuff
        Glide.with(holder.itemView.context).load(currentItem.img).into(holder.image)

        holder.titleText.text = currentItem.title
        holder.yearText.text = currentItem.year.toString()
        holder.castingText.text = currentItem.actors.joinToString(", ")

    }
    override fun getItemCount(): Int = dataList.size
}
