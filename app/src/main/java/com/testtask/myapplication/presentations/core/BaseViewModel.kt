package com.testtask.myapplication.presentations.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.testtask.myapplication.domain.AppState
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel() {
    protected val mutableLiveData: MutableLiveData<AppState> = MutableLiveData()
    fun getLiveData(): LiveData<AppState> = mutableLiveData

    abstract  fun getData()
    protected val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }
    )

    abstract fun handleError(throwable: Throwable)
    override fun onCleared() {
        viewModelCoroutineScope.cancel()
        super.onCleared()
    }
}