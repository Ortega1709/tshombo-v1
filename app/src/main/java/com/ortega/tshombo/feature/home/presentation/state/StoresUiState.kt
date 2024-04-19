package com.ortega.tshombo.feature.home.presentation.state

import com.ortega.tshombo.feature.home.domain.entity.StoreEntity

data class StoresUiState(
    val loading: Boolean = false,
    val stores: List<StoreEntity>? = null,
    val error: String = ""
)
