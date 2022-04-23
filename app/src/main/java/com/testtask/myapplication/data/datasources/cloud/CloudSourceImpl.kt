package com.testtask.myapplication.data.datasources.cloud

import com.testtask.myapplication.data.datasources.api.ServiceApi
import com.testtask.myapplication.data.modelresponse.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CloudSourceImpl(
    private val service: ServiceApi
) : CloudSource {
    override  fun getData(): Flow<Response> = flow <Response> {
        emit(service.getMovies())
    }

    override fun getNextData(offset: Int): Flow<Response> = flow<Response> {
        emit(service.getNextPageMovies(offset = offset))
    }
}