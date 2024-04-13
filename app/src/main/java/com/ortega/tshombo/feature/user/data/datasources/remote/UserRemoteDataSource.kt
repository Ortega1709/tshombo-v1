package com.ortega.tshombo.feature.user.data.datasources.remote

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.user.domain.entity.UserEntity
import retrofit2.Response
import retrofit2.http.GET

interface UserRemoteDataSource {

    @GET("users")
    suspend fun getAllUsers(): Response<Res<List<UserEntity>>>


}