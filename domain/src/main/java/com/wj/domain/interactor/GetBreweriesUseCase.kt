package com.wj.domain.interactor

import com.wj.domain.repo.BreweryRepo

class GetBreweriesUseCase(private val breweryRepo: BreweryRepo) {

    suspend fun getBreweries(
        pageNumber: Int? = null,
    ) = breweryRepo.getBreweries(pageNumber)

}