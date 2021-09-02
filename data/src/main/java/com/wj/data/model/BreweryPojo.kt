package com.wj.data.model

import com.google.gson.annotations.SerializedName

data class BreweryPojo(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("street") val street: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("website_url") val websiteUrl: String?,
)