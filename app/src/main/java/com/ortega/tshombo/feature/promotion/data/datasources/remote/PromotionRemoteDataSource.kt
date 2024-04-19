package com.ortega.tshombo.feature.promotion.data.datasources.remote

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.promotion.domain.entity.PromotionEntity
import com.ortega.tshombo.feature.promotion.domain.request.PromotionRequest
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface PromotionRemoteDataSource {

    @POST("{storeId}/promotions")
    suspend fun addPromotion(
        @Path("storeId") storeId: Int,
        @Body promotionRequest: PromotionRequest
    ): Response<Res<PromotionEntity>>

    @GET("promotions")
    suspend fun getAllPromotions(): Response<Res<List<PromotionEntity>>>

    @Multipart
    @POST("storage/promotions/{promotionId}/upload")
    suspend fun uploadFilePromotion(
        @Path("promotionId") promotionId: Int,
        @Part image: MultipartBody.Part
    ): Response<Res<PromotionEntity>>

    @DELETE("promotions/{promotionId}")
    suspend fun deletePromotion(@Path("promotionId") promotionId: Int): Response<Res<PromotionEntity>>
}