package com.testtask.myapplication.data.datasources.api

import com.testtask.myapplication.BuildConfig
import com.testtask.myapplication.data.modelresponse.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {
    @GET("/svc/movies/v2/reviews/all.json")
    suspend fun getMovies(@Query("api-key") apikey: String = BuildConfig.MOVIE_DB_APIKEY): Response
}