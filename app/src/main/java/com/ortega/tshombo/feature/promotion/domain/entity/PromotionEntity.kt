package com.ortega.tshombo.feature.promotion.domain.entity

data class PromotionEntity(
    val promotionId: Int,
    val name: String,
    val description: String,
    val image: String?,
    val endDate: String,
    val store: StoreEntity
)