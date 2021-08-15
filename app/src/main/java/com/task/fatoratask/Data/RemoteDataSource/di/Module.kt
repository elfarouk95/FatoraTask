package com.task.fatoratask.Data.RemoteDataSource.di

import com.task.fatoratask.Data.RemoteDataSource.Impi.ApiHelperImpl
import com.task.fatoratask.Data.RemoteDataSource.api.RetrofitBuilder
import com.task.fatoratask.Domin.Contracts.ApiHelper
import org.koin.dsl.module

val ApiHelperModule = module {
    single {
        ApiHelperImpl(RetrofitBuilder.apiService) as ApiHelper
    }
}

