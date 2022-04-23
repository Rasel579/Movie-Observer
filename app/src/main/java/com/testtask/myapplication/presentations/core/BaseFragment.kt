package com.testtask.myapplication.presentations.core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.testtask.myapplication.domain.AppState
import org.koin.core.scope.Scope

abstract class BaseFragment<T : ViewBinding>(@LayoutRes id: Int) : Fragment(id) {
    abstract val scope: Scope
    abstract val viewBinding: T
    abstract val viewModel: BaseViewModel
    abstract fun renderData(appState: AppState)
    override fun onStart() {
        super.onStart()
        viewModel.getLiveData().observe(viewLifecycleOwner) { renderData(it) }
    }
}