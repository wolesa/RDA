package com.wj.demoapp821.view.brewerieslist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.wj.demoapp821.R
import com.wj.demoapp821.view.main.MainViewModel

class BreweriesListFragment : Fragment(R.layout.breweries_list_fragment) {

    private val viewModel: MainViewModel by activityViewModels()


}