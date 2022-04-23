package com.testtask.myapplication.presentations.core

import androidx.lifecycle.ViewModel
import com.testtask.myapplication.domain.models.Movie

abstract class BaseViewModel: ViewModel() {
    abstract fun getData(): List<Movie>
}