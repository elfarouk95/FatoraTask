package com.task.fatoratask.Data.LocalDataSource

import androidx.room.*
import com.task.fatoratask.Domin.Bodies.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getFavItems(): Flow<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFav(q: Movie)

    @Delete
    fun deleteFav(q: Movie)

    @Query("SELECT FROM Movie where id = :q")
    fun getItem(q: Int): Movie
}