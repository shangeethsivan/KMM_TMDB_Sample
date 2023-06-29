package com.example.tmdbsample.repository

import com.example.tmdbsample.api.TMDBApi
import com.example.tmdbsample.models.Movie
import com.example.tmdbsample.models.Region

class MovieRepositoryImpl : MovieRepository {

    private val tmDBApi = TMDBApi()

    override suspend fun getMovies(region: Region): List<Movie> {
        return tmDBApi.getAllMovies(region.isoCode).data
    }
}