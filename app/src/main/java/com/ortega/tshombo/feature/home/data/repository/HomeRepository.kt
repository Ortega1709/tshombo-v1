package com.ortega.tshombo.feature.home.data.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.home.data.datasources.remote.HomeRemoteDataSource
import com.ortega.tshombo.feature.home.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.home.domain.entity.StoreEntity
import com.ortega.tshombo.feature.home.domain.repository.IHomeRepository
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeRemoteDataSource: HomeRemoteDataSource): IHomeRepository {
    override suspend fun getAllPhones(): Response<Res<List<PhoneEntity>>> {
        return homeRemoteDataSource.getAllPhones()
    }

    override suspend fun getAllPhonesByNews(): Response<Res<List<PhoneEntity>>> {
        return homeRemoteDataSource.getAllPhonesByNews()
    }

    override suspend fun getAllStores(): Response<Res<List<StoreEntity>>> {
        return homeRemoteDataSource.getAllStores();
    }

}