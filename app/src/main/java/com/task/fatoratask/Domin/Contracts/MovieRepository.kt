package com.task.fatoratask.Domin.Contracts

import com.task.fatoratask.Domin.Bodies.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getPopularity(page: Int = 1): List<Movie?>?
    suspend fun getRecent(page: Int = 1): List<Movie?>?
    suspend fun getFav(): Flow<List<Movie>>
    suspend fun insertFav(q: Movie)
    suspend fun deleteFav(q: Movie)
}