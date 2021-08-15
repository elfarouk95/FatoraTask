package com.task.fatoratask.Core.di

import com.task.fatoratask.Core.ui.Home.adapter.MovieAdapter
import com.task.fatoratask.Core.ui.Home.viewModel.FavViewModel
import com.task.fatoratask.Core.ui.Home.viewModel.PopularityViewModel
import com.task.fatoratask.Core.ui.Home.viewModel.getRecentViewModel
import org.koin.dsl.module


val PopularityViewModelModule = module {
    single { PopularityViewModel(get()) }
}

val getRecentViewModelModule = module {
    single { getRecentViewModel(get()) }
}

val FavViewModelModule = module {
    single { FavViewModel(get(), get(), get()) }
}

