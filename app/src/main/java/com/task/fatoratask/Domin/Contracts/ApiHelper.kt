package com.task.fatoratask.Domin.Contracts

import com.task.fatoratask.Domin.Containers.MovieResponse

interface ApiHelper {

    suspend fun popularity(page: Int = 1): MovieResponse

    suspend fun recent(page: Int = 1): MovieResponse
}