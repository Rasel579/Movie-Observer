package com.testtask.myapplication.data.datasources.mapers

import com.testtask.myapplication.data.modelresponse.Response
import com.testtask.myapplication.domain.models.Movie

class MapToMovie: MapMovie {
    override  fun map(data: Any): List<Movie> =
        (data as Response).movies.map {
            Movie(
                it.displayTitle,
                it.summaryShort,
                it.multimedia.src
            )
        }
    }