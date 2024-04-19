package com.ortega.tshombo.feature.promotion.domain.request

data class PromotionRequest(
    val name: String,
    val description: String,
    val endDate: String
)
