package com.example.repasoparcial.data

import com.example.repasoparcial.data.model.PokemonModel

//TODO:Data burner
val name = "pokemon"
val type = "normal"
val qualification = "9"

val name1 = "bulbasaur"
val type1 = "normal"
val qualification1 = "8.5"

//TODO:Insert Data burned
var pokemons = mutableListOf(
    PokemonModel(name, type, qualification),
    PokemonModel(name1, type1, qualification1)
)

