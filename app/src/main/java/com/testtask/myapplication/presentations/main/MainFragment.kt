package com.testtask.myapplication.presentations.main

import by.kirich1409.viewbindingdelegate.viewBinding
import com.testtask.myapplication.R
import com.testtask.myapplication.databinding.MainFragmentBinding
import com.testtask.myapplication.presentations.core.BaseFragment

class MainFragment : BaseFragment<MainFragmentBinding>(R.layout.main_fragment) {
    override val viewBinding: MainFragmentBinding by viewBinding()


    companion object {
        fun newInstance() = MainFragment()
    }
}