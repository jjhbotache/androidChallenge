package com.example.a5imdb.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a5imdb.R
import com.example.a5imdb.adapters.MoviesAdapter
import com.example.a5imdb.classes.Movie
import com.example.a5imdb.classes.SearchResponse
import com.example.a5imdb.mocks.movie1
import com.example.a5imdb.mocks.movie2
import com.example.a5imdb.mocks.movie3
import com.example.a5imdb.mocks.movie4
import com.example.a5imdb.databinding.FragmentSearchBinding
import com.google.gson.Gson
import khttp.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Search : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchInput: EditText = binding.searchInput
        val itemsContainer: RecyclerView = binding.itemsContainer
        val data: List<Movie> = listOf(movie1, movie2, movie3, movie4)

        searchInput.addTextChangedListener {
            lateinit var data: List<Movie>
            val task = GlobalScope.launch { data = askAndSetDesigns(searchInput.text.toString()) }
            runBlocking {
                task.join()
                itemsContainer.layoutManager =
                    LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                itemsContainer.adapter = MoviesAdapter(data)
            }
        }

        itemsContainer.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        itemsContainer.adapter = MoviesAdapter(data)
    }

    private suspend fun askAndSetDesigns(query: String): List<Movie> {
        val data: MutableList<Movie> = mutableListOf()
        val response =
            get("https://api.themoviedb.org/3/search/movie?api_key=043404d0ac80686f27d0dee6f4dfb260&query=$query")
        Log.d("get", "Status Code: ${response.statusCode}")
        Log.d("get", "Response Body: ${response.text}")
        val obj = Gson().fromJson(response.text, SearchResponse::class.java)

        obj.results.forEach { resultMovie ->
            // adapt the results to the movies classes
            data.add(
                Movie(
                    resultMovie.title,
                    resultMovie.release_date.substring(0, 4).toInt(),
                    "???",
                    listOf("???"),
                    resultMovie.vote_count.toDouble(),
                    "https://image.tmdb.org/t/p/w200${resultMovie.poster_path}"
                )
            )
        }
        return data
    }


}
