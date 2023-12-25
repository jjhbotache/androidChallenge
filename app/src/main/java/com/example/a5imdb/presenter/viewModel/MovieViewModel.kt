package com.example.a5imdb.presenter.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a5imdb.data.model.MovieModel
import com.example.a5imdb.data.model.MovieProvider
import com.example.a5imdb.domain.useCases.MovieCallbackInterface
import com.example.a5imdb.domain.useCases.MoviesUseCase

class MovieViewModel : ViewModel() {
    // this just care about logic and update data
    // don't care about ui views or something
    val moviesLiveData : MutableLiveData< MutableList<MovieModel> > = MutableLiveData()

    //this function was just used for testing
    fun getNextMovie() {

        val currentSize = moviesLiveData.value?.size ?: 0

        if (currentSize < MovieProvider.movies.size) {
            val nextMovie = MovieProvider.movies[currentSize]
            val currentMoviesList: MutableList<MovieModel> = moviesLiveData.value ?: mutableListOf()
            currentMoviesList.add(nextMovie)
            moviesLiveData.value = currentMoviesList
        }
    }

    fun searchMovies(movieNameToSearch : String){
        fun onMovies(movies:MutableList<MovieModel>?){ moviesLiveData.value = movies?.toMutableList() }




        MoviesUseCase.searchMovies(
            movieNameToSearch,
            // object is used to create a lambda obj
            object: MovieCallbackInterface {
                override fun function(response: List<MovieModel>) {
                    moviesLiveData.value = response?.toMutableList()
                }
            }
        )
    }
}