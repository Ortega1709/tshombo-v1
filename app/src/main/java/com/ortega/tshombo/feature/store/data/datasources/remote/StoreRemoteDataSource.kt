package com.ortega.tshombo.feature.store.data.datasources.remote

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.home.domain.entity.StoreEntity
import com.ortega.tshombo.feature.store.domain.request.StoreRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface StoreRemoteDataSource {

    @GET("stores")
    suspend fun getAllStores(): Response<Res<List<StoreEntity>>>

    @POST("{userId}/stores")
    suspend fun addStore(@Path("userId") userId: Int, @Body storeRequest: StoreRequest): Response<Res<StoreEntity>>

}