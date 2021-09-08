package com.wj.demoapp821.view.brewerieslist

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.wj.demoapp821.R
import com.wj.demoapp821.common.RecyclerViewOnClickListener
import com.wj.demoapp821.utils.observeStateFlow
import com.wj.demoapp821.view.main.MainViewModel
import com.wj.domain.model.Brewery
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

const val LOADING_ITEMS_BUFFER = 3

class BreweriesListFragment : Fragment(R.layout.breweries_list_fragment) {

    private val viewModel by sharedViewModel<MainViewModel>()

    private var breweriesList: RecyclerView? = null
    private var progressBar: ProgressBar? = null

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

        breweriesList = view.findViewById(R.id.breweriesList)
        progressBar = view.findViewById(R.id.progress_bar)

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

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.sharedFlow.collect {
                findNavController().navigate(R.id.action_breweriesListFragment_to_breweryDetailsFragment)
            }
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