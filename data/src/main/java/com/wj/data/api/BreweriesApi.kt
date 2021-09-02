package com.wj.data.api

import com.wj.data.model.BreweryPojo
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweriesApi {

    @GET("breweries")
    suspend fun getBreweries(
        @Query("by_city") city: String? = null,
        @Query("by_name") name: String? = null,
        @Query("page") pageNumber: Int? = null,
        @Query("numberOnPage") breweriesOnPage: Int? = null,
    ): List<BreweryPojo>

}