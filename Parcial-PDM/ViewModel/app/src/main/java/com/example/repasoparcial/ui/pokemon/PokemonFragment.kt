package com.example.repasoparcial.ui.pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.repasoparcial.R
import com.example.repasoparcial.databinding.FragmentPokemonBinding
import com.example.repasoparcial.ui.pokemon.viewmodel.PokemonViewModel


class PokemonFragment : Fragment() {

    private val pokemonViewModel: PokemonViewModel by activityViewModels{
        PokemonViewModel.Factory
    }

    private lateinit var binding: FragmentPokemonBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPokemon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentPokemonBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun setViewPokemon(){
        binding.viewModel = pokemonViewModel

    }


}