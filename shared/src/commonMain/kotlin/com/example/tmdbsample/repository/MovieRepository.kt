package com.example.tmdbsample.repository

import com.example.tmdbsample.models.Movie
import com.example.tmdbsample.models.Region

interface MovieRepository {

    suspend fun getMovies(region: Region): List<Movie>
}