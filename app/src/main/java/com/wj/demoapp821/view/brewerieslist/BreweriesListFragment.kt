package com.wj.demoapp821.view.brewerieslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.wj.demoapp821.R
import com.wj.demoapp821.utils.findView
import com.wj.demoapp821.utils.observeStateFlow
import com.wj.demoapp821.view.main.MainViewModel

class BreweriesListFragment : Fragment(R.layout.breweries_list_fragment) {

    private val viewModel: MainViewModel by activityViewModels()
    private val breweriesList: RecyclerView? by findView(R.id.breweriesList)
    private val adapter = BreweriesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        breweriesList?.adapter = adapter

        observeStateFlow(viewModel.breweriesListStateFlow) {
            adapter.submitList(it)
        }

    }
}