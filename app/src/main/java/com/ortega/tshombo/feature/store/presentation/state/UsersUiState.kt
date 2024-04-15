package com.ortega.tshombo.feature.store.presentation.state

import com.ortega.tshombo.feature.home.domain.entity.StoreEntity

data class StoresUiState(
    val loading: Boolean = false,
    val users: List<StoreEntity> = emptyList(),
    val error: String = ""
)