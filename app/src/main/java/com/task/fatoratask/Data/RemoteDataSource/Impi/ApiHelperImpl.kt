package com.task.fatoratask.Data.RemoteDataSource.Impi

import com.task.fatoratask.Data.RemoteDataSource.service.ApiService
import com.task.fatoratask.Domin.Containers.MovieResponse
import com.task.fatoratask.Domin.Contracts.ApiHelper

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun popularity(page: Int): MovieResponse {
        return apiService.popularity(page)
    }

    override suspend fun recent(page: Int): MovieResponse {
        return apiService.recent(page)
    }
}