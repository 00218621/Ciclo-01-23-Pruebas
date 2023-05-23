package com.example.repasoparcial.ui.pokemon.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.repasoparcial.PokemonReviewerApplication
import com.example.repasoparcial.data.model.PokemonModel
import com.example.repasoparcial.repositories.PokemonRepository

class PokemonViewModel(private val repository: PokemonRepository): ViewModel() {
    var name = MutableLiveData("")
    var type = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")

    fun getPokemons()= repository.getPokemons()

    fun addPokemons(pokemon: PokemonModel)=repository.addPokemons(pokemon)

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            type.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        name.value = ""
        type.value = ""
        qualification.value = ""
    }

    fun setSelectedPokemon(pokemon: PokemonModel){
        name.value = pokemon.name
        type.value = pokemon.type
        qualification.value = pokemon.qualification
    }

    fun createPokemon(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val movie = PokemonModel(
            name.value!!,
            type.value!!,
            qualification.value!!
        )
        addPokemons(movie)
        clearData()
        status.value= POKEMON_CREATED
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokemonReviewerApplication
                PokemonViewModel(app.pokemonRepository)
            }
        }
        const val POKEMON_CREATED = "Pokemon created"
        const val WRONG_INFORMATION = "Wring information"
        const val INACTIVE = ""
    }





}

/*
class MovieViewModel(private val repository: MovieRepository): ViewModel() {
    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")
    fun getMovies()= repository.getMovies()

    fun addMovies(movie: MovieModel)= repository.addMovies(movie)

    fun createMovie(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val movie = MovieModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!
        )
        addMovies(movie)
        clearData()
        status.value= MOVIE_CREATED
    }




    fun clearStatus(){
        status.value = INACTIVE
    }



}
* */