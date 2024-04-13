package com.ortega.tshombo.feature.home.domain.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.home.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.home.domain.entity.StoreEntity
import retrofit2.Response

interface IHomeRepository {

    suspend fun getAllPhones(): Response<Res<List<PhoneEntity>>>
    suspend fun getAllPhonesByNews(): Response<Res<List<PhoneEntity>>>
    suspend fun getAllStores(): Response<Res<List<StoreEntity>>>

}