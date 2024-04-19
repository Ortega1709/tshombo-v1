package com.ortega.tshombo.feature.myStore.domain.request

data class PhoneRequest(
    val phoneId: Int?,
    val brand: String,
    val description: String,
    val price: Double,
    val image: String
)
