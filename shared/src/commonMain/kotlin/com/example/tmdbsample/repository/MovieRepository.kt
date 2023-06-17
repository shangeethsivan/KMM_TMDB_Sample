package com.example.tmdbsample.repository

import com.example.tmdbsample.models.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>
}