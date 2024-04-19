package com.ortega.tshombo.feature.myStore.presentation.state

import com.ortega.tshombo.feature.myStore.domain.entity.PhoneEntity

data class MyStorePhoneUiState(
    val loading: Boolean = false,
    val phone: List<PhoneEntity>? = null,
    val error: String = ""
)