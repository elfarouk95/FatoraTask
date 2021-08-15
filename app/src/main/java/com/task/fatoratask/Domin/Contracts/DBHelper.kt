package com.task.fatoratask.Domin.Contracts


import com.task.fatoratask.Domin.Bodies.Movie
import kotlinx.coroutines.flow.Flow

interface DBHelper {

    suspend fun getFavItems(): Flow<List<Movie>>


    suspend fun insertFav(q: Movie)

    suspend fun deleteFav(q: Movie)

    suspend fun getItem(q: Int): Movie
}