package com.testtask.myapplication.presentations.main

import android.os.Bundle
import android.util.Log
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.testtask.myapplication.R
import com.testtask.myapplication.databinding.MainFragmentBinding
import com.testtask.myapplication.domain.AppState
import com.testtask.myapplication.presentations.core.BaseFragment
import com.testtask.myapplication.presentations.core.BaseViewModel
import org.koin.android.ext.android.getKoin
import org.koin.core.scope.Scope

class MainFragment : BaseFragment<MainFragmentBinding>(R.layout.main_fragment) {
    override val viewBinding: MainFragmentBinding by viewBinding()
    override val scope: Scope = getKoin().createScope<MainFragment>()
    override val viewModel: MainViewModel = scope.get()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getData()
    }

    override fun renderData(appState: AppState) {
        when(appState){
            is AppState.Success -> Log.e("data", appState.data.toString())
            is AppState.Error ->Log.e("data", appState.throwable.toString())
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
