package com.task.fatoratask.Core.ui.Home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.task.fatoratask.Domin.Bodies.Movie
import com.task.fatoratask.UseCase.getRecent
import com.task.fatoratask.Util.Resource


class getRecentViewModel(val getRecent: getRecent) : ViewModel() {

    var currentPage: Int = 1

    var MovieLiveData = MutableLiveData<Resource<List<Movie?>>>()

    init {
        getRecentViewLiveData()
    }

    fun getRecentViewLiveData() {
        MovieLiveData.postValue(Resource.loading(data = null))
        try {
            var res: List<Movie?>? = null
            getRecent(currentPage) {
                it?.let {
                    MovieLiveData.postValue((Resource.success(data = it)))
                }
            }

        } catch (e: Throwable) {
            MovieLiveData.postValue(Resource.error(data = null, error(e.message.toString())))
        }
    }

    fun fetchMorePage() {
        currentPage++
        getRecentViewLiveData()
    }

    fun resetCurrentPage()
    {
        currentPage =1
    }
}