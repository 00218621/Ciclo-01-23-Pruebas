package com.example.laboratorio_05.ui.movie.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.databinding.MovieItemBinding

class MovieRecyclerViewAdapter(private val clickListener: (MovieModel) -> Unit

) : RecyclerView.Adapter<MovieRecyclerViewHolder>() {
    private val movies = ArrayList<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        var movie = movies[position]
        holder.bind(movie,clickListener)
            /*
            var mov = Intent(c,MovieFragment::class.java)
            mov.putExtra("name",movie.name)
            c.startActivity(mov)
            */



    }
    fun setData(moviesList: List<MovieModel>){
        movies.clear()
        movies.addAll(moviesList)
    }

}