package com.example.tmdbsample.api

import com.example.tmdbsample.models.MoviesWrapper
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class TMDBApi {

    private val httpClient = HttpClient {
        defaultRequest {
            url {
                headers.append("Authorization", "Bearer $API_KEY")
            }
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
        install(Logging) {
            level = LogLevel.ALL
        }
    }

    suspend fun getAllMovies(region: String): MoviesWrapper {
        return httpClient.get("$BASE_URL/discover/movie") {
            url {
                parameters.append("region", region)
            }
        }.body()
    }

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original"
        const val API_KEY =
            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMzRhYWNhM2JhZDYxNWE0N2RjOTgyY2FjMzQ0M2RmOSIsInN1YiI6IjU5MmMzZjUwOTI1MTQxM2I0YTA3NjY3ZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.tDzcMlDp_qmohytir_7thUh2vth2-x7OkfWE4qm08UY"
    }
}