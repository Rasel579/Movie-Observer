package com.testtask.myapplication.presentations.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.testtask.myapplication.databinding.ItemMovieBinding
import com.testtask.myapplication.domain.models.Movie

class MovieAdapter(
    private val movies: MutableList<Movie>,
    private val getData: (Int) -> Any
) : RecyclerView.Adapter<MovieAdapter.MovieItem>() {
    private var page = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItem =
        MovieItem(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MovieItem, position: Int) {
        holder.bind(movies[position])
        if (position == movies.size - 15){
               ++page
               getData.invoke(page)
        }
    }

    override fun getItemCount(): Int = movies.size

    fun addPage(data: List<Movie>){
        movies.addAll(data)
        notifyDataSetChanged()
    }

    inner class MovieItem(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.titleMovie.text = movie.title
            binding.descriptionMovie.text = movie.description
            Glide.with(binding.root.context)
                .load(movie.imageURI)
                .fitCenter()
                .into(binding.posterMovie)
        }

    }
}