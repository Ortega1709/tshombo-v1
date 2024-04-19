package com.ortega.tshombo.feature.myStore.data.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.myStore.data.datasources.remote.MyStoreRemoteDataSource
import com.ortega.tshombo.feature.myStore.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.myStore.domain.entity.StoreEntity
import com.ortega.tshombo.feature.myStore.domain.repository.IMyStoreRepository
import com.ortega.tshombo.feature.myStore.domain.request.PhoneRequest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class MyStoreRepository @Inject constructor(private val myStoreRemoteDataSource: MyStoreRemoteDataSource) :
    IMyStoreRepository {
    override suspend fun getStoreByUserId(userId: Int): Response<Res<StoreEntity>> {
        return myStoreRemoteDataSource.getStoreByUserId(userId)
    }

    override suspend fun addPhone(
        storeId: Int,
        phoneRequest: PhoneRequest
    ): Response<Res<PhoneEntity>> {
        return myStoreRemoteDataSource.addPhone(storeId = storeId, phoneRequest = phoneRequest)
    }

    override suspend fun uploadFilePhone(phoneId: Int, image: File): Response<Res<PhoneEntity>> {
        val requestFile = image.asRequestBody("image/*".toMediaTypeOrNull())
        val imagePart = MultipartBody.Part.createFormData("file", image.name, requestFile)
        return myStoreRemoteDataSource.uploadFilePhone(phoneId = phoneId, image = imagePart)
    }
}