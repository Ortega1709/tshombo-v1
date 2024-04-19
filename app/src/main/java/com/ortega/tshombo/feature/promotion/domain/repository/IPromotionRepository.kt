package com.ortega.tshombo.feature.promotion.domain.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.promotion.domain.entity.PromotionEntity
import com.ortega.tshombo.feature.promotion.domain.request.PromotionRequest
import retrofit2.Response
import java.io.File

interface IPromotionRepository {

    suspend fun addPromotion(storeId: Int, promotionRequest: PromotionRequest): Response<Res<PromotionEntity>>
    suspend fun uploadFilePromotion(promotionId: Int, image: File): Response<Res<PromotionEntity>>
    suspend fun getAllPromotions(): Response<Res<List<PromotionEntity>>>
    suspend fun deletePromotion(promotionId: Int): Response<Res<PromotionEntity>>


}