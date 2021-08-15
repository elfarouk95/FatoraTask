package com.task.fatoratask.UseCase

import com.task.fatoratask.Domin.Bodies.Movie
import com.task.fatoratask.Domin.Contracts.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class getFav(var movieRepository: MovieRepository) {
    operator fun invoke(onResult: (List<Movie>) -> Unit = {}) {

        GlobalScope.launch(Dispatchers.IO) {
            val res = movieRepository.getFav()

            GlobalScope.launch(Dispatchers.Main.immediate)
            {
                res.collect {
                    onResult(it)
                }
            }
        }
    }


}