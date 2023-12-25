package com.example.a5imdb.data.repositories

import com.example.a5imdb.data.classes.Movie
import com.example.a5imdb.data.interfaces.MovieApiService
import com.example.a5imdb.data.interfaces.RetrofitInterface

class MoviesRepository {
    private val apiService = RetrofitInterface.buildRetrofitObj("https://api.themoviedb.org/3/")
        .create(MovieApiService::class.java)

    suspend fun getPopularMovies(): List<Movie> {
        // Implementa la lógica para obtener las películas populares usando Retrofit y corutinas
        return try {
            val response = apiService.getPopularMovies().execute()
            response.body()?.results ?: emptyList()
        } catch (e:Exception){
            emptyList()
        }
    }

    suspend fun getMoviesFromMovieName(movieName: String): List<Movie> {
        return try {
            val response = apiService.searchMovies(queryParameter = movieName).execute()
            response.body()?.results ?: emptyList()
        } catch (e: Exception) {
            // Manejar excepciones durante la llamada a la API
            emptyList()
        }
    }
}
