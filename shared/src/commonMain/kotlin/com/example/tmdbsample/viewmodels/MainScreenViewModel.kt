package com.example.tmdbsample.viewmodels

import com.example.tmdbsample.models.Movie
import com.example.tmdbsample.repository.MovieRepository
import com.example.tmdbsample.repository.MovieRepositoryImpl
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel : KMMViewModel() {

    private val repository: MovieRepository = MovieRepositoryImpl()

    private val _uiState = MutableStateFlow<UiState>(viewModelScope, UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.coroutineScope.launch {
            try {
                val movies = repository.getMovies()
                _uiState.update { UiState.Data(movies) }
            } catch (ex: Exception) {
                _uiState.update { UiState.Error("Api Failure") }
            }
        }
    }


    sealed interface UiState {
        data class Data(
            val movies: List<Movie>
        ) : UiState

        data class Error(
            val errorMessage: String
        ) : UiState

        object Loading : UiState
    }
}