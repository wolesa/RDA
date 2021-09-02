package com.wj.demoapp821.view.brewerieslist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wj.demoapp821.R

class BreweriesListFragment : Fragment() {

    companion object {
        fun newInstance() = BreweriesListFragment()
    }

    private lateinit var viewModel: BreweriesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.breweries_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BreweriesListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}