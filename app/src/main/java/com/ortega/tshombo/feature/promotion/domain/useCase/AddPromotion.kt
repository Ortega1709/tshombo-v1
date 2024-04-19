package com.ortega.tshombo.feature.promotion.domain.useCase

import android.util.Log
import com.ortega.tshombo.feature.promotion.domain.entity.PromotionEntity
import com.ortega.tshombo.feature.promotion.domain.repository.IPromotionRepository
import com.ortega.tshombo.feature.promotion.domain.request.PromotionRequest
import retrofit2.HttpException
import java.io.File
import java.io.IOException
import javax.inject.Inject

class AddPromotion @Inject constructor(private val iPromotionRepository: IPromotionRepository) {

    suspend operator fun invoke(
        image: File,
        storeId: Int,
        promotionRequest: PromotionRequest,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        try {
            val response = iPromotionRepository.addPromotion(
                storeId = storeId,
                promotionRequest = promotionRequest
            )
            if (response.code() == 201) {
                if (response.body() != null) {
                    Log.d("PROMOTION", response.body()!!.data.toString())
                    val promotionEntity: PromotionEntity = response.body()!!.data

                    uploadFile(
                        promotionId = promotionEntity.promotionId,
                        image = image,
                        onSuccess = {
                            onSuccess()
                        },
                        onError = {
                            onError(it)
                        },
                    )
                }
            } else {
                onError("Add error")
            }

        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }

    }

    private suspend fun uploadFile(
        promotionId: Int,
        image: File,
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
    ) {
        try {
            val response = iPromotionRepository.uploadFilePromotion(promotionId = promotionId, image = image)
            onSuccess()
        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }
    }

}