package com.wj.demoapp821.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wj.domain.interactor.GetBreweriesUseCase
import com.wj.domain.model.Brewery
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val getBreweriesUseCase: GetBreweriesUseCase) : ViewModel() {

    private val _breweriesListStateFlow = MutableStateFlow<List<Brewery>>(emptyList())
    val breweriesListStateFlow = _breweriesListStateFlow.asStateFlow()

    private val _breweryDetailsStateFlow = MutableStateFlow<Brewery?>(null)
    val breweryDetailsStateFlow = _breweryDetailsStateFlow.asStateFlow()

    private var city: String? = null
    private var name: String? = null
    private var pageNumber: Int = 0

    init {

        breweriesListStateFlow.collect {  }
        searchBreweries()
    }

    fun searchBreweries(city: String? = null,
                        name: String? = null, ){
        val isNewSearch = this.city != city || this.name != name

        if(isNewSearch){
            pageNumber = 0
            this.city = city
            this.name = name
        }

        getNextPage()
    }

    private fun getNextPage() {
        pageNumber++

        viewModelScope.launch {
            _breweriesListStateFlow.apply {
                value = value + getBreweriesUseCase.getBreweries(
                    city,
                    name,
                    pageNumber
                )
            }
        }
    }


}