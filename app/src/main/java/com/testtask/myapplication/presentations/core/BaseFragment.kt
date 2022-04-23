package com.testtask.myapplication.presentations.core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T: ViewBinding>(@LayoutRes id: Int): Fragment(id) {
    abstract val viewBinding: T
}