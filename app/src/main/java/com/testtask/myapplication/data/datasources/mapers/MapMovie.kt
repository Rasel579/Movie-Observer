package com.testtask.myapplication.data.datasources.mapers

import com.testtask.myapplication.domain.models.Movie

interface MapMovie {
     fun map(data: Any): List<Movie>
}