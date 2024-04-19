package com.ortega.tshombo.feature.myStore.domain.entity

import com.ortega.tshombo.feature.store.domain.entity.StoreEntity

data class PhoneEntity(
    val phoneId: Int,
    val brand: String,
    val description: String,
    val price: Double,
    val image: String,
)