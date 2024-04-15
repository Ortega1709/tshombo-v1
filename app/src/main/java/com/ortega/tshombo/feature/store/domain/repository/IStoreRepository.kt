package com.ortega.tshombo.feature.store.domain.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.home.domain.entity.StoreEntity
import com.ortega.tshombo.feature.store.domain.request.StoreRequest
import retrofit2.Response

interface IStoreRepository {

    suspend fun getAllStores(): Response<Res<List<StoreEntity>>>
    suspend fun addStore(userId: Int, storeRequest: StoreRequest): Response<Res<StoreEntity>>

}