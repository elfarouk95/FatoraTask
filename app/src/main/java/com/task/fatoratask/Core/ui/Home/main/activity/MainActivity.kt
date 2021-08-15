package com.task.fatoratask.Core.ui.Home.main.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.task.fatoratask.Core.ui.Home.adapter.MovieAdapter
import com.task.fatoratask.Core.ui.Home.adapter.PaginationScrollListener
import com.task.fatoratask.Core.ui.Home.viewModel.FavViewModel
import com.task.fatoratask.Core.ui.Home.viewModel.PopularityViewModel
import com.task.fatoratask.Core.ui.Home.viewModel.getRecentViewModel
import com.task.fatoratask.Domin.Bodies.Movie
import com.task.fatoratask.Util.Status
import com.task.fatoratask.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val adapter: MovieAdapter = MovieAdapter()
    lateinit var binding: ActivityMainBinding

    private val recentViewModel: getRecentViewModel by viewModel()
    private val popularityViewModel: PopularityViewModel by viewModel()
    private val FavViewModel: FavViewModel by viewModel()

    var pos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(this, 2)

        binding.tabs.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                setSelect(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        popularityViewModel.MovieLiveData.observe(this, {
            when (it.status) {
                Status.SUCCESS -> adapter.arrayList = it.data as ArrayList<Movie>?
            }
        })

        recentViewModel.MovieLiveData.observe(this, {
            when (it.status) {
                Status.SUCCESS -> adapter.arrayList = it.data as ArrayList<Movie>?
            }
        })

        popularityViewModel.getPopularityLiveData()

        binding.list.addOnScrollListener(object :
            PaginationScrollListener(binding.list.layoutManager as GridLayoutManager) {
            override fun isLoading(): Boolean {
                return false
            }

            override fun isLastPage(): Boolean {
                return false;
            }

            override fun loadMoreItems() {
                if (pos == 0)
                    popularityViewModel.fetchMorePage()
                else
                    recentViewModel.fetchMorePage()
            }
        })
        binding.list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })

        
    }

    private fun setSelect(position: Int) {
        if (pos != position) {
            adapter.clearItem()
            if (pos == 0)
            {
                popularityViewModel.resetCurrentPage()
            }
            else{
                recentViewModel.resetCurrentPage()
            }
        }

        pos = position
        when (position) {
            0 -> popularityViewModel.getPopularityLiveData()
            1 -> recentViewModel.getRecentViewLiveData()
        }


    }
}