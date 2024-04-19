package com.ortega.tshombo.feature.promotion.domain.useCase

import com.ortega.tshombo.feature.promotion.data.repository.PromotionRepository
import com.ortega.tshombo.feature.promotion.domain.entity.PromotionEntity
import com.ortega.tshombo.feature.promotion.domain.repository.IPromotionRepository
import com.ortega.tshombo.feature.user.domain.entity.UserEntity
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPromotions @Inject constructor(private val iPromotionRepository: IPromotionRepository) {

    suspend operator fun invoke(
        onSuccess: (List<PromotionEntity>) -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iPromotionRepository.getAllPromotions()
            if (response.code() == 200) {
                if (response.body() != null) {
                    onSuccess(response.body()!!.data)
                }
            } else {
                onError("Fetching error")
            }

        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }
    }

}