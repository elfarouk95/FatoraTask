package com.task.fatoratask.Data.RemoteDataSource.api

import com.task.fatoratask.Data.RemoteDataSource.auth.ApiKeyInterceptor
import com.task.fatoratask.Data.RemoteDataSource.service.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://api.themoviedb.org/"

    private fun getRetrofit(): Retrofit {
        val client = OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor()).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}