package com.example.laboratorio_05.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio_05.R
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.databinding.FragmentBillboardBinding
import com.example.laboratorio_05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.example.laboratorio_05.ui.movie.viewmodel.MovieViewModel


class BillboardFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }
    private lateinit var binding: FragmentBillboardBinding
    private lateinit var adapter: MovieRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnNavCreateNewMovie.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    private fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = MovieRecyclerViewAdapter{selectedMovie ->
            showSelectedItem(selectedMovie)
        }
        binding.recyclerView.adapter = adapter
        displayMovies()
    }
    companion object{
        const val INTENT_="OBJECT"
    }

    private fun displayMovies(){
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private  fun showSelectedItem(movie:MovieModel){
        movieViewModel.setSelectedMovie(movie)

        findNavController().navigate(R.id.action_firstFragment_to_threeFragment)

        /*      val bundle = Bundle()
        bundle.putString("name_movie",movie.name)
        val fragment = MovieFragment()
        fragment.arguments = bundle
        */
    }

}