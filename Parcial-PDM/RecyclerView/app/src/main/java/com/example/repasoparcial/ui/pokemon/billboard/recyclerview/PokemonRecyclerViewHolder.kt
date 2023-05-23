package com.example.repasoparcial.ui.pokemon.billboard.recyclerview

import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.repasoparcial.data.model.PokemonModel
import com.example.repasoparcial.databinding.ItemPokemonBinding

class PokemonRecyclerViewHolder(private val binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root)
{
    fun bind(pokemon: PokemonModel, clickListener: (PokemonModel)-> Unit){
    binding.namePokemon.text= pokemon.name
    binding.typeText.text=pokemon.type
    binding.qualificationText.text=pokemon.qualification
    binding.pokemonItemCardView.setOnClickListener {
        clickListener(pokemon)
    }
}
}

/*

class MovieRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root)
{
    fun bind(movie: MovieModel, clickListener:(MovieModel)-> Unit){
        binding.titleTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener {
            clickListener(movie)
        }
    }
}
* */