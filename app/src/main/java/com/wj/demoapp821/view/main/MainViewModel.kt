package com.wj.demoapp821.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wj.domain.interactor.GetBreweriesUseCase
import com.wj.domain.model.Brewery
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val getBreweriesUseCase: GetBreweriesUseCase) : ViewModel() {

    private val _breweriesListStateFlow = MutableStateFlow<List<Brewery>>(emptyList())
    val breweriesListStateFlow = _breweriesListStateFlow.asStateFlow()

    private val _breweryDetailsStateFlow = MutableStateFlow<Brewery?>(null)
    val breweryDetailsStateFlow = _breweryDetailsStateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<Unit>()
    val sharedFlow = _sharedFlow.asSharedFlow()

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

            _breweriesListStateFlow.value = _breweriesListStateFlow.value + breweries
        }
    }

    fun onBreweryClicked(brewery: Brewery){
        _breweryDetailsStateFlow.value = brewery

        viewModelScope.launch {
            _sharedFlow.emit(Unit)
        }
    }
}