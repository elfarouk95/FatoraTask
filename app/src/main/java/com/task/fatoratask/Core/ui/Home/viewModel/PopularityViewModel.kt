package com.task.fatoratask.Core.ui.Home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.task.fatoratask.Domin.Bodies.Movie
import com.task.fatoratask.UseCase.getPopularity
import com.task.fatoratask.Util.Resource

class PopularityViewModel(private val getPopularity: getPopularity) : ViewModel() {

    var currentPage: Int = 1

    var MovieLiveData = MutableLiveData<Resource<List<Movie?>>>()

    init {
        getPopularityLiveData()
    }

    fun getPopularityLiveData() {
        MovieLiveData.postValue(Resource.loading(data = null))
        try {
            var res: List<Movie?>? = null
            getPopularity(currentPage) {
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
        getPopularityLiveData()
    }

    fun resetCurrentPage()
    {
        currentPage =1
    }
}