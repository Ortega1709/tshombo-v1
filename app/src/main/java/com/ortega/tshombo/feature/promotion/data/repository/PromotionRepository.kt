package com.ortega.tshombo.feature.promotion.data.repository

import android.content.Context
import android.net.Uri
import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.promotion.data.datasources.remote.PromotionRemoteDataSource
import com.ortega.tshombo.feature.promotion.domain.entity.PromotionEntity
import com.ortega.tshombo.feature.promotion.domain.repository.IPromotionRepository
import com.ortega.tshombo.feature.promotion.domain.request.PromotionRequest
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class PromotionRepository @Inject constructor(private val promotionRemoteDataSource: PromotionRemoteDataSource) :
    IPromotionRepository {
    override suspend fun addPromotion(
        storeId: Int,
        promotionRequest: PromotionRequest
    ): Response<Res<PromotionEntity>> {
        return promotionRemoteDataSource.addPromotion(
            storeId = storeId,
            promotionRequest = promotionRequest
        )
    }

    override suspend fun uploadFilePromotion(
        promotionId: Int,
        image: File
    ): Response<Res<PromotionEntity>> {

        val requestFile = image.asRequestBody("image/*".toMediaTypeOrNull())
        val imagePart = MultipartBody.Part.createFormData("file", image.name, requestFile)
        return promotionRemoteDataSource.uploadFilePromotion(
            promotionId = promotionId,
            image = imagePart
        )
    }

    override suspend fun getAllPromotions(): Response<Res<List<PromotionEntity>>> {
        return promotionRemoteDataSource.getAllPromotions()
    }

    override suspend fun deletePromotion(promotionId: Int): Response<Res<PromotionEntity>> {
        return promotionRemoteDataSource.deletePromotion(promotionId = promotionId)
    }


}