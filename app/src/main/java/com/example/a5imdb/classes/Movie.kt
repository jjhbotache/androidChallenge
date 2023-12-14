package com.example.a5imdb.classes
/*
{
    "movie": {
    "title": "The Shawshank Redemption",
    "year": 1994,
    "genre": ["Drama", "Crime"],
    "director": "Frank Darabont",
    "actors": ["Tim Robbins", "Morgan Freeman"],
    "plot": "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
    "rating": 9.3

    let's add imgs=
    "img":"url..."
    }
}
 */


class Movie(
    val title: String,
    val year: Int,
    val director: String,
    val actors: List<String>,
    val rating: Double,
    val img : String
) {
}
