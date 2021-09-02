package com.wj.domain.repo

import com.wj.domain.model.Brewery

interface BreweryRepo {

    suspend fun getBreweries(
        city: String? = null,
        name: String? = null,
        pageNumber: Int? = null,
        breweriesOnPage: Int? = null,
    ): List<Brewery>

}