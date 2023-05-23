package com.example.repasoparcial.repositories

import com.example.repasoparcial.data.model.PokemonModel

//TODO:Implement Repository
class PokemonRepository(private val pokemons: MutableList<PokemonModel>) {
    fun getPokemons()= pokemons
    fun addPokemons(pokemon: PokemonModel)=pokemons.add(index = 0,pokemon)
}
