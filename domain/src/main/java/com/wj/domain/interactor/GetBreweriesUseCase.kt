package com.wj.domain.interactor

import com.wj.domain.repo.BreweryRepo

class GetBreweriesUseCase(private val breweryRepo: BreweryRepo) {

    suspend fun getBreweries(
        city: String? = null,
        name: String? = null,
        pageNumber: Int? = null,
        breweriesOnPage: Int? = null,
    ) = breweryRepo.getBreweries(city, name, pageNumber, breweriesOnPage)

}