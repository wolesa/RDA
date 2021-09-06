package com.wj.demoapp821.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wj.domain.interactor.GetBreweriesUseCase
import com.wj.domain.model.Brewery
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val getBreweriesUseCase: GetBreweriesUseCase) : ViewModel() {

    private val _breweriesListStateFlow = MutableStateFlow<List<Brewery>>(emptyList())
    val breweriesListStateFlow = _breweriesListStateFlow.asStateFlow()

    private val _breweryDetailsStateFlow = MutableStateFlow<Brewery?>(null)
    val breweryDetailsStateFlow = _breweryDetailsStateFlow.asStateFlow()

    private var pageNumber: Int = 0

    init {
        getNextPage()
    }

    fun getNextPage() {
        pageNumber++

        viewModelScope.launch {
            val breweries = getBreweriesUseCase.getBreweries(
                pageNumber = pageNumber
            )

            _breweriesListStateFlow.value = breweries
        }
    }
}