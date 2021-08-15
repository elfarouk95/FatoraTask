package com.task.fatoratask.Core.ui.Home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.task.fatoratask.Domin.Bodies.Movie

import com.task.fatoratask.UseCase.deleteFav
import com.task.fatoratask.UseCase.getFav
import com.task.fatoratask.UseCase.insertFav


class FavViewModel(val insertfav: insertFav, val deletefav: deleteFav, val getFav: getFav) :
    ViewModel() {

    var MovieLiveData = MutableLiveData<List<Movie>>()

    private fun getFavMovie() {
        getFav {
            MovieLiveData.value = it
        }
    }

    init {
        getFavMovie()
    }

    fun insertFav(q: Movie) = insertfav(q)

    fun deleteFav(q: Movie) = deletefav(q)

}