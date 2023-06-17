package com.example.tmdbsample.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Movie(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("poster_path")
    val imagePath: String,
    @SerialName("overview")
    val description: String,
)

@Serializable
class MoviesWrapper(
    @SerialName("results")
    val data: List<Movie>
)