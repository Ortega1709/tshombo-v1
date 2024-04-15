package com.ortega.tshombo.feature.store.domain.request

import com.ortega.tshombo.feature.store.domain.entity.LocationEntity

data class StoreRequest(
    val name: String,
    val city: String,
    val avenue: String,
    val commune: String,
    val rccm: String,
    val location: LocationRequest
)
