package com.example.repasoparcial.ui.pokemon.newpokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.repasoparcial.R
import com.example.repasoparcial.databinding.FragmentNewPokemonBinding
import com.example.repasoparcial.ui.pokemon.viewmodel.PokemonViewModel


class NewPokemonFragment : Fragment() {
    private val pokemonViewModel: PokemonViewModel by activityViewModels {
        PokemonViewModel.Factory
    }
    private lateinit var binding: FragmentNewPokemonBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPokemon()
        observerStatus()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewPokemonBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun setViewPokemon(){
        binding.viewModel = pokemonViewModel
    }
    companion object {
        const val APP_TAG = "APP TAG"
    }
    private fun observerStatus(){
        pokemonViewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(PokemonViewModel.WRONG_INFORMATION) -> {
                    Toast.makeText(requireContext(), PokemonViewModel.WRONG_INFORMATION, Toast.LENGTH_LONG).show()
                    Log.d(APP_TAG,status)
                    pokemonViewModel.clearStatus()
                }
                status.equals(PokemonViewModel.POKEMON_CREATED) -> {
                    Toast.makeText(requireContext(), PokemonViewModel.POKEMON_CREATED, Toast.LENGTH_LONG).show()
                    Log.d(APP_TAG,status)
                    Log.d(APP_TAG,pokemonViewModel.getPokemons().toString())
                    pokemonViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }


}

