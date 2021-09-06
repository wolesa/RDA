package com.wj.demoapp821.view.brewerydetails

import androidx.fragment.app.Fragment
import com.wj.demoapp821.R
import com.wj.demoapp821.view.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class BreweryDetailsFragment : Fragment(R.layout.brewery_details_fragment) {

    val viewModel by sharedViewModel<MainViewModel>()


}