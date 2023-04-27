package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.laboratorio_05.R
import com.example.laboratorio_05.databinding.FragmentBillboardBinding


/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BillboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var buttonFirstFragment: CardView
    private lateinit var buttonFirsThreeFragment: CardView

    private lateinit var binding: FragmentBillboardBinding
    private val viewModel: MovieViewModel by viewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_billboard, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bin()
        buttonFirstFragment.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        buttonFirsThreeFragment.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_threeFragment)
        }
        val adapter = MovieAdapter {
            Toast.makeText(requireContext(), "Click en ${it.name}", Toast.LENGTH_LONG).show()
            Toast.makeText(requireContext(), "Click en ${it.category}", Toast.LENGTH_LONG).show()
            Toast.makeText(requireContext(), "Click en ${it.description}", Toast.LENGTH_LONG).show()
            Toast.makeText(requireContext(), "Click en ${it.qualification}", Toast.LENGTH_LONG).show()

        }
        binding.recylerViewMovie.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.getMovies()
    }

    fun bin(){
        buttonFirstFragment=view?.findViewById(R.id.new_movie_button) as CardView
        buttonFirsThreeFragment=view?.findViewById(R.id.one_card)as CardView
    }

}