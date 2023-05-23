package com.example.repasoparcial

import android.app.Application
import com.example.repasoparcial.data.pokemons
import com.example.repasoparcial.repositories.PokemonRepository

class PokemonReviewerApplication:Application() {
    val pokemonRepository: PokemonRepository by lazy {
        PokemonRepository(pokemons)
    }
}

