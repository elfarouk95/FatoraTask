package com.task.fatoratask.UseCase

import com.task.fatoratask.Domin.Bodies.Movie
import com.task.fatoratask.Domin.Contracts.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class insertFav(var movieRepository: MovieRepository) {
    operator fun invoke(q: Movie) {

        GlobalScope.launch(Dispatchers.IO) {
            val res = movieRepository.insertFav(q)
        }
    }
}