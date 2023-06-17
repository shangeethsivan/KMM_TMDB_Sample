package com.example.tmdbsample.android.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.tmdbsample.android.widgets.MovieCard
import com.example.tmdbsample.models.Movie


@Composable
fun MainScreenViewWithData(movies: List<Movie>) {
    LazyColumn(
        contentPadding = PaddingValues(1.dp)
    ) {
        movies.forEach {
            item { MovieCard(movie = it) }
        }
    }
    /*
    HorizontalPager(pageCount = movies.size) { page ->
        MovieCard(movie = movies[page])
    }
     */
}