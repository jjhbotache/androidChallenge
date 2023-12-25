package com.example.a5imdb.data.model

class MovieModel(
    val title: String,
    val year: Int,
    val director: String,
    val actors: List<String>,
    val rating: Double,
    val img : String
) {
}