package com.example.a5imdb.data.classes
import kotlinx.serialization.Serializable
@Serializable
data class SearchResponse(
    val page: Int,
    val results: List<responseMovie>,
    val total_pages: Int,
    val total_results: Int
)
@Serializable
data class responseMovie(
    val adult: Boolean,
    val backdrop_path: String?,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
