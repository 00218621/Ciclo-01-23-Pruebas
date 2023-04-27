package com.example.laboratorio_05.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio_05.MovieReviewerAplication
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.repositories.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {
    fun getMovies()= repository.getMovies()

    fun addMovies(movie: MovieModel)= repository.addMovies(movie)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerAplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}