package com.example.repasoparcial.ui.pokemon.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.repasoparcial.data.model.PokemonModel
import com.example.repasoparcial.databinding.ItemPokemonBinding

class PokemonRecyclerViewAdapter(private val clickListener: (PokemonModel) -> Unit
): RecyclerView.Adapter<PokemonRecyclerViewHolder>() {
    private val pokemons = ArrayList<PokemonModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonRecyclerViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return PokemonRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: PokemonRecyclerViewHolder, position: Int) {
        var pokemon = pokemons[position]
        holder.bind(pokemon,clickListener)
    }

    fun setData(moviesList: List<PokemonModel>){
        pokemons.clear()
        pokemons.addAll(moviesList)
    }

}

