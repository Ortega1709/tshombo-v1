package com.ortega.tshombo.feature.home.data.datasources.remote

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.home.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.home.domain.entity.StoreEntity
import retrofit2.Response
import retrofit2.http.GET


interface HomeRemoteDataSource {

    @GET("phones")
    suspend fun getAllPhones(): Response<Res<List<PhoneEntity>>>
    @GET("phones")
    suspend fun getAllPhonesByNews(): Response<Res<List<PhoneEntity>>>



    @GET("stores")
    suspend fun getAllStores(): Response<Res<List<StoreEntity>>>

}