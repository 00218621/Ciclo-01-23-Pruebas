package com.example.repasoparcial.ui.pokemon.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repasoparcial.R
import com.example.repasoparcial.data.model.PokemonModel
import com.example.repasoparcial.databinding.FragmentBillboardBinding
import com.example.repasoparcial.ui.pokemon.billboard.recyclerview.PokemonRecyclerViewAdapter
import com.example.repasoparcial.ui.pokemon.viewmodel.PokemonViewModel


class BillboardFragment : Fragment() {

    private val pokemonViewModel: PokemonViewModel by activityViewModels{
        PokemonViewModel.Factory
    }
    private lateinit var binding: FragmentBillboardBinding
    private lateinit var adapter: PokemonRecyclerViewAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentBillboardBinding.inflate(inflater,container,false)
        return  binding.root
    }
    private  fun showSelectedItem(pokemon:PokemonModel){
        pokemonViewModel.setSelectedPokemon(pokemon)
        findNavController().navigate(R.id.action_billboardFragment_to_pokemonFragment)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnNavNewPokemon.setOnClickListener {
            pokemonViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newPokemonFragment)
        }
    }


    private fun displayPokemons(){
        adapter.setData(pokemonViewModel.getPokemons())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = PokemonRecyclerViewAdapter{selectedMovie ->
            showSelectedItem(selectedMovie)
        }
        binding.recyclerView.adapter = adapter
        displayPokemons()
    }
    companion object{
        const val INTENT_="OBJECT"
    }

}

