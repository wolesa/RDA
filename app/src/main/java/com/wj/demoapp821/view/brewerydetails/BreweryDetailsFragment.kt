package com.wj.demoapp821.view.brewerydetails

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.wj.demoapp821.R
import com.wj.demoapp821.utils.observeStateFlow
import com.wj.demoapp821.view.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class BreweryDetailsFragment : Fragment(R.layout.brewery_details_fragment) {

    val viewModel by sharedViewModel<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeStateFlow(viewModel.breweryDetailsStateFlow) {
            Log.d("BreweryDetailsFragment", "Brewery: ${it.toString()}")
        }
    }
}