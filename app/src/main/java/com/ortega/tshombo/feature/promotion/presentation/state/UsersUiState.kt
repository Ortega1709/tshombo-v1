package com.ortega.tshombo.feature.promotion.presentation.state

import com.ortega.tshombo.feature.promotion.domain.entity.PromotionEntity

data class PromotionsUiState(
    val loading: Boolean = false,
    val promotions: List<PromotionEntity> = emptyList(),
    val error: String = ""
)