package com.example.a5imdb.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a5imdb.model.MovieModel
import com.example.a5imdb.model.MovieProvider

class MovieViewModel : ViewModel() {
    val moviesLiveData : MutableLiveData< MutableList<MovieModel> > = MutableLiveData()

    fun getNextMovie() {
        val currentSize = moviesLiveData.value?.size ?: 0

        if (currentSize < MovieProvider.movies.size) {
            val nextMovie = MovieProvider.movies[currentSize]
            val currentMoviesList: MutableList<MovieModel> = moviesLiveData.value ?: mutableListOf()
            currentMoviesList.add(nextMovie)
            moviesLiveData.value = currentMoviesList
        }
    }
}