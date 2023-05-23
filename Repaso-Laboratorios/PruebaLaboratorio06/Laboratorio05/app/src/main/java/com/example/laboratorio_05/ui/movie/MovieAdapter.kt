package com.example.laboratorio_05.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_05.R
import com.example.laboratorio_05.data.model.MovieModel

class MovieAdapter(private val onClickBook: (MovieModel) -> Unit) : RecyclerView.Adapter<MovieAdapter.ViewHolderBook>() {

    private var movies: List<MovieModel>? = null

    class ViewHolderBook(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieModel, onClickBook: (MovieModel) -> Unit ) {
            val nameTextView: TextView = itemView.findViewById(R.id.name_movie)
            val categoryTextView: TextView = itemView.findViewById(R.id.category_movie)
            val descriptionTextView: TextView = itemView.findViewById(R.id.description_movie)
            val qualificationTextView: TextView = itemView.findViewById(R.id.qualification_movie)

            nameTextView.text = movie.name
            categoryTextView.text = movie.category
            descriptionTextView.text = movie.description
            qualificationTextView.text = movie.qualification

            nameTextView.setOnClickListener {
                onClickBook(movie)
            }
            categoryTextView.setOnClickListener {
                onClickBook(movie)
            }
            descriptionTextView.setOnClickListener {
                onClickBook(movie)
            }
            qualificationTextView.setOnClickListener {
                onClickBook(movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBook {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.movie_billboard, parent, false)
        return ViewHolderBook(view)
    }

    override fun getItemCount(): Int = movies?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolderBook, position: Int) {
        movies?.let {
            holder.bind(it[position], onClickBook)
        }
    }

    fun submitData(books: List<MovieModel>) {
        this.movies = books
        notifyDataSetChanged()
    }
}