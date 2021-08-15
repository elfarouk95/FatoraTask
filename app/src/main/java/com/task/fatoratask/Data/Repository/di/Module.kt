package com.task.fatoratask.Data.Repository.di

import com.task.fatoratask.Data.Repository.MovieRepositoryImpl
import com.task.fatoratask.Domin.Contracts.MovieRepository
import org.koin.dsl.module

val MovieRepositoryImplMoudle = module {
    single { MovieRepositoryImpl(get(), get()) as MovieRepository
    }
}