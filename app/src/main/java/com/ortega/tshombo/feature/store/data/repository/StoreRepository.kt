package com.ortega.tshombo.feature.store.data.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.home.domain.entity.StoreEntity
import com.ortega.tshombo.feature.store.data.datasources.remote.StoreRemoteDataSource
import com.ortega.tshombo.feature.store.domain.repository.IStoreRepository
import com.ortega.tshombo.feature.store.domain.request.StoreRequest
import retrofit2.Response
import javax.inject.Inject

class StoreRepository @Inject constructor(private val storeRemoteDataSource: StoreRemoteDataSource): IStoreRepository {
    override suspend fun getAllStores(): Response<Res<List<StoreEntity>>> {
        return storeRemoteDataSource.getAllStores()
    }

    override suspend fun addStore(userId: Int, storeRequest: StoreRequest): Response<Res<StoreEntity>> {
        return storeRemoteDataSource.addStore(userId = userId, storeRequest = storeRequest)
    }
}