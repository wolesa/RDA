package com.wj.demoapp821.view

import com.wj.demoapp821.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel { MainViewModel(get()) }
}