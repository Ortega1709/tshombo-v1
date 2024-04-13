package com.ortega.tshombo.feature.home.domain.entity

data class StoreEntity(
    val storeId: Int,
    val name: String,
    val city: String,
    val avenue: String,
    val commune: String,
    val image: String,
    val location: LocationEntity
)
