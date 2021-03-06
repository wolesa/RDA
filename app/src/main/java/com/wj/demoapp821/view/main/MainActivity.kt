package com.wj.demoapp821.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wj.demoapp821.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}