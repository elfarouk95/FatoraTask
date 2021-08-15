package com.task.fatoratask.UseCase

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.bumptech.glide.load.engine.Resource
import com.task.fatoratask.Domin.Bodies.Movie
import com.task.fatoratask.Domin.Contracts.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class getPopularity(var movieRepository: MovieRepository) {
    operator fun invoke(page: Int = 1, onResult: (List<Movie?>?) -> Unit = {}) {

        try {
            GlobalScope.launch(Dispatchers.IO) {
                val res = movieRepository.getPopularity(page)

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