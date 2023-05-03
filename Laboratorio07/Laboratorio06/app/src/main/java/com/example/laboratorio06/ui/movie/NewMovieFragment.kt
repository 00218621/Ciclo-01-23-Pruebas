package com.example.laboratorio06.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.laboratorio06.R
import com.example.laboratorio06.data.model.MovieModel
import com.example.laboratorio06.data.model.movies
import com.example.laboratorio06.databinding.FragmentNewMovieBinding
import com.example.laboratorio06.repositories.MovieRepository


class NewMovieFragment : Fragment() {


    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentNewMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewMovie()
        observerStatus()
    }

    private fun setViewMovie(){
        binding.viewModel = movieViewModel
    }


    private fun observerStatus(){
        movieViewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Toast.makeText(requireContext(),MovieViewModel.WRONG_INFORMATION,Toast.LENGTH_LONG).show()
                    Log.d(APP_TAG,status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Toast.makeText(requireContext(),MovieViewModel.MOVIE_CREATED,Toast.LENGTH_LONG).show()
                    Log.d(APP_TAG,status)
                    Log.d(APP_TAG,movieViewModel.getMovies().toString())
                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
    companion object {
        const val APP_TAG = "APP TAG"
    }
}