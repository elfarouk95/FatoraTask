package com.task.fatoratask.Domin.Containers

import com.google.gson.annotations.SerializedName
import com.task.fatoratask.Domin.Bodies.Movie

data class MovieResponse(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<Movie?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)
