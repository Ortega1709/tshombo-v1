package com.ortega.tshombo.feature.myStore.data.datasources.remote

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.myStore.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.myStore.domain.entity.StoreEntity
import com.ortega.tshombo.feature.myStore.domain.request.PhoneRequest
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface MyStoreRemoteDataSource {

    @GET("{userId}/stores")
    suspend fun getStoreByUserId(@Path("userId") userId: Int): Response<Res<StoreEntity>>

    @POST("{storeId}/phones")
    suspend fun addPhone(
        @Path("storeId") storeId: Int,
        @Body phoneRequest: PhoneRequest
    ): Response<Res<PhoneEntity>>

    @Multipart
    @POST("storage/phones/{phoneId}/upload")
    suspend fun uploadFilePhone(
        @Path("phoneId") phoneId: Int,
        @Part image: MultipartBody.Part
    ): Response<Res<PhoneEntity>>


}