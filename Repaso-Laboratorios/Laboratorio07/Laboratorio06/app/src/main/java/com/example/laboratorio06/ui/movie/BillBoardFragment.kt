package com.example.laboratorio06.ui.movie


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio06.R
import com.example.laboratorio06.data.adapter.MovieAdapter
import com.example.laboratorio06.data.model.movies
import com.example.laboratorio06.databinding.FragmentBillBoardBinding
import com.example.laboratorio06.databinding.FragmentNewMovieBinding
import com.example.laboratorio06.repositories.MovieRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BillBoardFragment : Fragment() {

    private lateinit var buttonFragmentNewMovie: FloatingActionButton
    private lateinit var recyclerViewMovies: RecyclerView
    private lateinit var binding: FragmentBillBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBillBoardBinding.inflate(inflater,container,false)
        return binding.root
    }
//DESDE AQUÍ TE FALTÓ

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()

        val repository = MovieRepository(movies)
        val adapter = MovieAdapter()
        adapter.setData(repository.getMovies())

        recyclerViewMovies.adapter = adapter
        recyclerViewMovies.layoutManager = LinearLayoutManager(context)
    }

    private fun bind(){
        buttonFragmentNewMovie = view?.findViewById(R.id.btn_link_new_movie) as FloatingActionButton
        recyclerViewMovies = view?.findViewById(R.id.movies_recycle_view) as RecyclerView
    }

    private fun listeners(){
        buttonFragmentNewMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_billBoardFragment_to_newMovieFragment)
        }
    }

    //HASTA AQUÍ

}




