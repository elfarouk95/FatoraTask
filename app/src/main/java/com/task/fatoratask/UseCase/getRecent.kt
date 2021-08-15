package com.task.fatoratask.UseCase

import com.task.fatoratask.Domin.Bodies.Movie
import com.task.fatoratask.Domin.Contracts.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class getRecent(var movieRepository: MovieRepository) {
    operator fun invoke(page: Int = 1, onResult: (List<Movie?>?) -> Unit = {}) {
        try {
            GlobalScope.launch(Dispatchers.IO) {
                val res = movieRepository.getRecent(page)

                GlobalScope.launch(Dispatchers.Main.immediate)
                {
                    onResult(res)
                }
            }
        } catch (e: Throwable) {
            onResult(null)
        }
    }
}