package com.wj.domain.repo

import com.wj.domain.model.Brewery

interface BreweryRepo {

    suspend fun getBreweries(
        pageNumber: Int? = null,
    ): List<Brewery>

}