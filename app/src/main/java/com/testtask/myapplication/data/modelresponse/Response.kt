package com.testtask.myapplication.data.modelresponse

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val movies: List<MovieResponse>,
    @SerializedName("status")
    val status: String
)