package com.example.a5imdb.data.model

class MovieProvider {
    companion object{
        val movies:List<MovieModel> = listOf(
            MovieModel(
                "The Shawshank Redemption",
                1994,
                "Frank Darabont",
                listOf("Tim Robbins", "Morgan Freeman"),
                9.3,
                "https://th.bing.com/th/id/R.1a45808705344108871e4b6c4a69d091?rik=UTb5P5AvidXR3A&pid=ImgRaw&r=0"
            ),
            MovieModel(
                "The Godfather",
                1972,
                "Francis Ford Coppola",
                listOf("Marlon Brando", "Al Pacino"),
                9.2,
                "https://th.bing.com/th/id/OIP.WIkTDeXPDy-v7XhUzmmjWAHaLd?rs=1&pid=ImgDetMain"
            ),
            MovieModel(
                "The Dark Knight",
                2008,
                "Christopher Nolan",
                listOf("Christian Bale", "Heath Ledger"),
                9.0,
                "https://th.bing.com/th/id/OIP.aKpSjIfVv3wavnhzInV1iwHaLH?rs=1&pid=ImgDetMain"
            ),
            MovieModel(
                "Inception",
                2010,
                "Christopher Nolan",
                listOf("Leonardo DiCaprio", "Joseph Gordon-Levitt"),
                8.8,
                "https://th.bing.com/th/id/R.19d62a9d88d57213763ed6733c6973c5?rik=cM5GgYhjYGh4IQ&pid=ImgRaw&r=0"
            )
        )
    }

}