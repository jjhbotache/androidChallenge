package com.example.a5imdb.domain.useCases

import android.util.Log
import com.example.a5imdb.data.classes.TheMovieDBApiResponse
import com.example.a5imdb.data.interfaces.MovieApiService
import com.example.a5imdb.data.interfaces.RetrofitInterface
import com.example.a5imdb.data.model.MovieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MoviesUseCase {
    companion object {
        fun searchMovies(movieNameToSearch: String, callback: MovieCallbackInterface) {
            val retrofit = RetrofitInterface.buildRetrofitObj("https://api.themoviedb.org/3/")
            val apiService = retrofit.create(MovieApiService::class.java)

            apiService.searchMovies(queryParameter = movieNameToSearch)
                .enqueue(object : Callback<TheMovieDBApiResponse> {
                    override fun onResponse(
                        call: Call<TheMovieDBApiResponse>,
                        response: Response<TheMovieDBApiResponse>
                    ) {
                        Log.d("call", response.toString())
                        Log.d("call", response.body().toString())

                        val movies = response.body()?.results?.map { resultMovie ->
                            MovieModel(
                                resultMovie.title,
                                resultMovie.releaseDate.substring(0, 4).toInt(),
                                "???",
                                listOf("???"),
                                resultMovie.voteCount.toDouble(),
                                "https://image.tmdb.org/t/p/w200${resultMovie.posterPath}"
                            )
                        }
                        val dataToReturn = movies ?: emptyList()
                        callback.function(dataToReturn)
                    }

                    override fun onFailure(call: Call<TheMovieDBApiResponse>, t: Throwable) {
                        callback.function(emptyList())
                    }
                })
        }

        fun getPopularMovies(callback: MovieCallbackInterface) {
            val retrofit = RetrofitInterface.buildRetrofitObj("https://api.themoviedb.org/3/")
            val apiService = retrofit.create(MovieApiService::class.java)

            apiService.getPopularMovies()
                .enqueue(object : Callback<TheMovieDBApiResponse> {
                    override fun onResponse(
                        call: Call<TheMovieDBApiResponse>,
                        response: Response<TheMovieDBApiResponse>
                    ) {
                        Log.d("call", response.toString())
                        Log.d("call", response.body().toString())

                        val movies = response.body()?.results?.map { resultMovie ->
                            MovieModel(
                                resultMovie.title,
                                resultMovie.releaseDate.substring(0, 4).toInt(),
                                "???",
                                listOf("???"),
                                resultMovie.voteCount.toDouble(),
                                "https://image.tmdb.org/t/p/w200${resultMovie.posterPath}"
                            )
                        }
                        val dataToReturn = movies ?: emptyList()
                        callback.function(dataToReturn)
                    }

                    override fun onFailure(call: Call<TheMovieDBApiResponse>, t: Throwable) {
                        callback.function(emptyList())
                    }
                })
        }

    }
}

interface MovieCallbackInterface {
    fun function(response : List<MovieModel>)
}