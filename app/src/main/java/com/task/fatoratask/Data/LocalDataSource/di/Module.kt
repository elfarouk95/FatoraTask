package com.task.fatoratask.Data.LocalDataSource.di

import com.task.fatoratask.Data.LocalDataSource.DBHelperImpI
import com.task.fatoratask.Data.LocalDataSource.DatabaseBuilder
import com.task.fatoratask.Domin.Contracts.DBHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val DBRepositoryImplModule = module {
    single {
        DBHelperImpI(DatabaseBuilder.getInstance(androidApplication())) as DBHelper
    }
}
