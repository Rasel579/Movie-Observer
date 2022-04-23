package com.testtask.myapplication.data.datasources

import com.testtask.myapplication.data.modelresponse.Response

interface CloudSource {
    fun getData(): Response
}