package com.ortega.tshombo.feature.promotion.domain.useCase

import com.ortega.tshombo.feature.promotion.domain.repository.IPromotionRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DeletePromotion @Inject constructor(private val iPromotionRepository: IPromotionRepository) {

    suspend operator fun invoke(
        promotionId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iPromotionRepository.deletePromotion(promotionId = promotionId)
            if (response.code() == 200) {
                onSuccess()
            } else {
                onError("Delete error")
            }

        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }
    }

}