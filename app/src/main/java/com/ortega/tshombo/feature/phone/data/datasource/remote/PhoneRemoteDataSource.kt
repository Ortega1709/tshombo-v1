package com.ortega.tshombo.feature.phone.data.datasource.remote

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.phone.domain.entity.PhoneEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneRemoteDataSource {

    @GET("phones/{phoneId}")
    suspend fun getPhoneById(@Path("phoneId") phoneId: Int): Response<Res<PhoneEntity>>

}