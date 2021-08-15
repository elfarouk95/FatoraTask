package com.task.fatoratask.Core.ui.Home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.task.fatoratask.Data.LocalDataSource.DBHelperImpI
import com.task.fatoratask.Data.LocalDataSource.DatabaseBuilder
import com.task.fatoratask.Domin.Bodies.Movie
import com.task.fatoratask.Domin.Contracts.DBHelper
import com.task.fatoratask.R
import com.task.fatoratask.Util.Load
import com.task.fatoratask.databinding.MovieItemBinding

class MovieAdapter : ParentAdpater<MovieHolder, Movie>() {
    override fun get_layout(): Int {
        return R.layout.movie_item
    }

    override fun getViewHolder(v: View?): MovieHolder {
        return MovieHolder(v)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        val movie = getItem(position)

        movie.posterPath?.let { holder.binding.ivMoviePoster.Load(it) }

        holder.binding.tvMovieTitle.setText(movie.title)


        holder.binding.isFav.isChecked = movie.isFav!!




    }
}


class MovieHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    var binding: MovieItemBinding

    init {
        binding = MovieItemBinding.bind(itemView!!)
    }
}