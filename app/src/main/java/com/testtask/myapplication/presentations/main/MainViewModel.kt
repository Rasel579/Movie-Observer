package com.testtask.myapplication.presentations.main

import com.testtask.myapplication.domain.AppState
import com.testtask.myapplication.domain.repository.Repository
import com.testtask.myapplication.presentations.core.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
) : BaseViewModel() {

    override fun getData() {
        viewModelCoroutineScope.launch {
            repository.getData().collect {
                mutableLiveData.postValue(AppState.Success(it))
            }
        }
    }
    fun getNextPage(page: Int){
        viewModelCoroutineScope.launch {
            repository.getNextPage(page).collect {
                mutableLiveData.postValue(AppState.SuccessNextPage(it))
            }
        }
    }

    override fun handleError(throwable: Throwable) {
        mutableLiveData.postValue(AppState.Error(throwable))
    }
}