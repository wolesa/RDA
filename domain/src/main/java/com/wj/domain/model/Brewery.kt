package com.wj.domain.model

data class Brewery(
    val id: Int,
    val name: String,
    val street: String?,
    val city: String?,
    val country: String?,
    val phone: String?,
    val websiteUrl: String?,
)
