package com.wj.demoapp821.view.brewerieslist

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.wj.demoapp821.R
import com.wj.demoapp821.common.RecyclerViewOnClickListener
import com.wj.demoapp821.utils.findView
import com.wj.demoapp821.utils.observeStateFlow
import com.wj.demoapp821.view.main.MainViewModel
import com.wj.domain.model.Brewery
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

const val LOADING_ITEMS_BUFFER = 3

class BreweriesListFragment : Fragment(R.layout.breweries_list_fragment) {

    private val viewModel by sharedViewModel<MainViewModel>()
    private val breweriesList: RecyclerView? by findView(R.id.breweriesList)
    private val progressBar: ProgressBar? by findView(R.id.progress_bar)

    private val breweriesAdapter = BreweriesAdapter(object : RecyclerViewOnClickListener<Brewery> {
        override fun onItemClick(item: Brewery) {
            viewModel.onBreweryClicked(item)
        }
    })

    private val onScrollListener = object : OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            (recyclerView.layoutManager as LinearLayoutManager).run {
                if (itemCount - findLastVisibleItemPosition() <= LOADING_ITEMS_BUFFER) {
                    showLoading()
                    viewModel.getNextPage()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dividerItem = DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
            setDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.divider) ?: return@apply
            )
        }

        breweriesList?.apply {
            layoutManager = LinearLayoutManager(
                this@BreweriesListFragment.requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = breweriesAdapter
            addItemDecoration(dividerItem)
            addOnScrollListener(onScrollListener)
        }

        observeStateFlow(viewModel.breweriesListStateFlow) { newList ->
            breweriesAdapter.apply { submitList(newList) }
            hideLoading()
        }

        observeStateFlow(viewModel.breweryDetailsStateFlow) {
            it?.run { findNavController().navigate(R.id.action_breweriesListFragment_to_breweryDetailsFragment) }
        }

    }

    private fun showLoading() {
        progressBar?.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        breweriesList?.visibility = View.VISIBLE
        progressBar?.visibility = View.GONE
    }
}