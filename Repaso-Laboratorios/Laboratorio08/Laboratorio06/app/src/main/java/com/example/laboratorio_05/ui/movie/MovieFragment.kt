package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.laboratorio_05.databinding.FragmentMovieBinding
import com.example.laboratorio_05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.example.laboratorio_05.ui.movie.viewmodel.MovieViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentMovieBinding
    private lateinit var adapter: MovieRecyclerViewAdapter




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewMovie()


    }
    /*
     val p = arguments?.getString("name_movie")
        val t : EditText = view.findViewById(R.id.title_movie)
        t.setText("Prueba ${p} " )

    private fun setInitialData(){
        val date = arguments?.getString("movie.name")
        _binding.titleMovie.setText(date)
    }
*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentMovieBinding.inflate(inflater,container,false)
        return binding.root

    }





    /*
    private  fun showSelectedItem(movie:MovieModel){
        movieViewModel.setSelectedMovie(movie)
        Toast.makeText(requireContext(),"p",Toast.LENGTH_SHORT)

    }
    private fun setRecyclerView(){
        adapter = MovieRecyclerViewAdapter{selectedMovie ->
            showSelectedItem(selectedMovie)
        }
    }
     */



    private fun setViewMovie(){
        binding.viewModel = movieViewModel

    }


    /*        findNavController().navigate(R.id.action_firstFragment_to_threeFragment)
*/
    }










