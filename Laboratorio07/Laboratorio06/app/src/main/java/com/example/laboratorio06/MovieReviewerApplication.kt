package com.example.laboratorio06

import android.app.Application
import com.example.laboratorio06.data.model.movies
import com.example.laboratorio06.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}