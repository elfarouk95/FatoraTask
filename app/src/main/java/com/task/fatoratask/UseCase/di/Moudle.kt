package com.task.fatoratask.UseCase.di

import com.task.fatoratask.UseCase.*
import org.koin.dsl.module

val getFavModule = module {
    single { getFav(get()) }
}


val deleteFavModule = module {
    single { deleteFav(get()) }
}

val insertFavModule = module {
    single { insertFav(get()) }
}


val getPopularityModule = module {
    single { getPopularity(get()) }
}

val getRecentModule = module {
    single { getRecent(get()) }
}