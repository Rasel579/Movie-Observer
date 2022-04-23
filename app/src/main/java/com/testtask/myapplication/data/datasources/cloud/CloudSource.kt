package com.testtask.myapplication.data.datasources.cloud

import com.testtask.myapplication.data.modelresponse.Response
import kotlinx.coroutines.flow.Flow

interface CloudSource {
    fun getData(): Flow<Response>
    fun getNextData(offset: Int): Flow<Response>
}