package com.example.tmdbsample.android.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tmdbsample.android.CoilImage
import com.example.tmdbsample.models.Movie


@Composable
fun MovieCard(movie: Movie) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .height(200.dp)
    ) {
        Box {
            Row {
                CoilImage(
                    imagePath = movie.imagePath,
                    contentDescription = movie.title,
                    modifier = Modifier.fillMaxHeight(),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = movie.title, color = Color.Black, fontWeight = FontWeight.Bold)
                    Text(text = movie.description)
                }
            }
        }

    }
}


@Preview
@Composable
fun MovieCardPreview() {
    val movie = Movie(
        id = 123,
        title = "X-men",
        imagePath = "/test/url",
        description = "test test  set as dfa df"
    )
    MovieCard(movie)
}