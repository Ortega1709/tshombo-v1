package com.ortega.tshombo.feature.myStore.domain.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.myStore.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.myStore.domain.entity.StoreEntity
import com.ortega.tshombo.feature.myStore.domain.request.PhoneRequest
import retrofit2.Response
import java.io.File

interface IMyStoreRepository {

    suspend fun getStoreByUserId(userId: Int): Response<Res<StoreEntity>>
    suspend fun addPhone(storeId: Int, phoneRequest: PhoneRequest): Response<Res<PhoneEntity>>
    suspend fun uploadFilePhone(phoneId: Int, image: File): Response<Res<PhoneEntity>>

}