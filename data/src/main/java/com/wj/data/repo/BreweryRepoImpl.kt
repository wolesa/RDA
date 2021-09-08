package com.wj.data.repo

import com.wj.data.api.BreweriesApi
import com.wj.domain.model.Brewery
import com.wj.domain.repo.BreweryRepo

class BreweryRepoImpl(private val breweriesApi: BreweriesApi) : BreweryRepo {

    override suspend fun getBreweries(
        pageNumber: Int?,
    ): List<Brewery> = breweriesApi.getBreweries(pageNumber)
        .mapNotNull { breweryPojo ->
            Brewery(
                breweryPojo.id ?: return@mapNotNull null,
                breweryPojo.name ?: return@mapNotNull null,
                breweryPojo.street,
                breweryPojo.city,
                breweryPojo.country,
                breweryPojo.phone,
                breweryPojo.websiteUrl,
            )
        }

}