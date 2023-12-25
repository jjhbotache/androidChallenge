package com.example.a5imdb.presenter.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a5imdb.presenter.adapters.MoviesAdapter
import com.example.a5imdb.databinding.FragmentSearchBinding
import com.example.a5imdb.presenter.viewModel.MovieViewModel

//this interface defines the calls we gonna do


class Search : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val movieViewModel : MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemsContainer: RecyclerView = binding.itemsContainer
        val searchButton : ImageView = binding.searchMagnifier
        itemsContainer.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)



        searchButton.setOnClickListener {
            movieViewModel.searchMovies(binding.searchInput.text.toString())
        }


        movieViewModel.moviesLiveData.observe(viewLifecycleOwner, Observer {
            itemsContainer.adapter = MoviesAdapter(it)
        })

    }

}
