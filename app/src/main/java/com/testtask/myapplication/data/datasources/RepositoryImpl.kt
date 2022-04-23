package com.testtask.myapplication.data.datasources

import com.testtask.myapplication.data.datasources.cloud.CloudSource
import com.testtask.myapplication.data.datasources.mapers.MapMovie
import com.testtask.myapplication.domain.models.Movie
import com.testtask.myapplication.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class RepositoryImpl(
    private val cloudSource: CloudSource,
    private val mapper: MapMovie
) : Repository {
    override fun getData(): Flow<List<Movie>> = cloudSource.getData().map { response ->
        mapper.map(response)
    }.flowOn(Dispatchers.IO)

    override fun getNextPage(offset: Int): Flow<List<Movie>> = cloudSource.getNextData(offset).map {
        mapper.map(it)
    }.flowOn(Dispatchers.IO)
}