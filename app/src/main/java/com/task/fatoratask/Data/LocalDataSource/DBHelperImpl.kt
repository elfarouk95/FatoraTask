package com.task.fatoratask.Data.LocalDataSource

import com.task.fatoratask.Domin.Bodies.Movie
import com.task.fatoratask.Domin.Contracts.DBHelper
import kotlinx.coroutines.flow.Flow

class DBHelperImpI(private val appDatabase: AppDatabase) : DBHelper {

    override suspend fun getFavItems(): Flow<List<Movie>> {
        return appDatabase.MovieDao().getFavItems()
    }

    override suspend fun insertFav(q: Movie) {
        appDatabase.MovieDao().insertFav(q)
    }

    override suspend fun deleteFav(q: Movie) {
        appDatabase.MovieDao().deleteFav(q)
    }

    override suspend fun getItem(q: Int): Movie {
        return appDatabase.MovieDao().getItem(q)
    }
}