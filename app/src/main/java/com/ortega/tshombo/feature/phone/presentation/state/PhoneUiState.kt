package com.ortega.tshombo.feature.phone.presentation.state

import com.ortega.tshombo.feature.phone.domain.entity.PhoneEntity

data class PhoneUiState(
    val loading: Boolean = false,
    val phone: PhoneEntity? = null,
    val error: String = ""
)