package com.wj.data.api

import com.wj.data.model.BreweryPojo
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweriesApi {

    @GET("breweries")
    suspend fun getBreweries(
        @Query("page") pageNumber: Int? = null,
    ): List<BreweryPojo>

}