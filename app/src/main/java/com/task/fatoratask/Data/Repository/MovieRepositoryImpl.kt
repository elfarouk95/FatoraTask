package com.task.fatoratask.Data.Repository

import com.task.fatoratask.Domin.Bodies.Movie
import com.task.fatoratask.Domin.Contracts.ApiHelper
import com.task.fatoratask.Domin.Contracts.DBHelper
import com.task.fatoratask.Domin.Contracts.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(
    val apiHelper: ApiHelper,
    val dbHelper: DBHelper
) : MovieRepository {

    override suspend fun getPopularity(page: Int): List<Movie?>? {
        return getisFav(apiHelper.popularity(page).results)
    }

    suspend fun getisFav(list: List<Movie?>?): List<Movie?>? {

        if (list != null) {
            for (x in list) {
                if (x?.id?.let { dbHelper.getItem(it) } != null) {
                    x.isFav = true
                }
            }
        }
        return list
    }

    override suspend fun getRecent(page: Int): List<Movie?>? {
        return getisFav(apiHelper.recent(page).results)
    }

    override suspend fun getFav(): Flow<List<Movie>> {
        return dbHelper.getFavItems()
    }

    override suspend fun insertFav(q: Movie) {
        dbHelper.insertFav(q)
    }

    override suspend fun deleteFav(q: Movie) {
        dbHelper.deleteFav(q)
    }


}