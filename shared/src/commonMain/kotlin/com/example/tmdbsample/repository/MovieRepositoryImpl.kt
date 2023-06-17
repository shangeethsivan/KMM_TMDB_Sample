package com.example.tmdbsample.repository

import com.example.tmdbsample.api.TMDBApi
import com.example.tmdbsample.models.Movie

class MovieRepositoryImpl : MovieRepository {

    private val tmDBApi = TMDBApi()

    override suspend fun getMovies(): List<Movie> {
        return tmDBApi.getAllMovies().data
    }
}