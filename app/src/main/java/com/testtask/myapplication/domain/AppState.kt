package com.testtask.myapplication.domain

sealed class AppState {
    data class Success(val data: Any) : AppState()
    data class Error(val throwable: Throwable) : AppState()
    object Loading : AppState()
}