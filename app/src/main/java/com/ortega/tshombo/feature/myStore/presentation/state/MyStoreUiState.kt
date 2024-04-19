package com.ortega.tshombo.feature.myStore.presentation.state

import com.ortega.tshombo.feature.myStore.domain.entity.StoreEntity


data class MyStoreUiState(
    val loading: Boolean = false,
    val store: StoreEntity? = null,
    val error: String = ""
)
