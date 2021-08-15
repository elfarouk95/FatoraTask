package com.task.fatoratask.Data.RemoteDataSource.service

import com.task.fatoratask.Domin.Containers.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/discover/movie?sort_by=popularity.desc")
    suspend fun popularity(@Query("page") page: Int = 1): MovieResponse


    @GET("3/discover/movie?sort_by=release_date.desc")
    suspend fun recent(@Query("page") page: Int = 1): MovieResponse

}