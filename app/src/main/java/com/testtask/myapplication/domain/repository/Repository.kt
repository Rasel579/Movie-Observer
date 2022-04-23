package com.testtask.myapplication.domain.repository

import com.testtask.myapplication.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface Repository {
     fun  getData(): Flow<List<Movie>>
     fun getNextPage(offset: Int): Flow<List<Movie>>
}