package com.ortega.tshombo.feature.myStore.domain.entity

data class PhoneEntity(
    val phoneId: Int,
    val brand: String,
    val description: String,
    val price: Double,
    val image: String,
    val store: StoreEntity
)