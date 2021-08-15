package com.task.fatoratask.Data.LocalDataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.task.fatoratask.Domin.Bodies.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun MovieDao(): MovieDao
}