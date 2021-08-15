package com.task.fatoratask.Core.base

import android.app.Application
import com.task.fatoratask.Core.di.FavViewModelModule
import com.task.fatoratask.Core.di.PopularityViewModelModule
import com.task.fatoratask.Core.di.getRecentViewModelModule
import com.task.fatoratask.Data.LocalDataSource.di.DBRepositoryImplModule
import com.task.fatoratask.Data.RemoteDataSource.di.ApiHelperModule
import com.task.fatoratask.Data.Repository.di.MovieRepositoryImplMoudle
import com.task.fatoratask.UseCase.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    ApiHelperModule,
                    PopularityViewModelModule,
                    getRecentViewModelModule,
                    FavViewModelModule,
                    getFavModule,
                    deleteFavModule,
                    insertFavModule,
                    getPopularityModule,
                    getRecentModule,
                    MovieRepositoryImplMoudle,
                    DBRepositoryImplModule
                )
            )
        }
    }
}