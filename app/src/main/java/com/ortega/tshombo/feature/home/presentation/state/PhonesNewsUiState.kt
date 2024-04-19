package com.ortega.tshombo.feature.home.presentation.state

import com.ortega.tshombo.feature.home.domain.entity.PhoneEntity

data class PhonesNewsUiState(
    val loading: Boolean = false,
    val phones: List<PhoneEntity>? = null,
    val error: String = ""
)
