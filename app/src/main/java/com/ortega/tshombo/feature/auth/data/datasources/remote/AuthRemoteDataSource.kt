package com.ortega.tshombo.feature.auth.data.datasources.remote

import com.ortega.tshombo.core.common.response.Response
import com.ortega.tshombo.feature.auth.data.datasources.remote.request.LoginRequest
import com.ortega.tshombo.feature.auth.data.datasources.remote.request.RegisterRequest
import com.ortega.tshombo.feature.auth.domain.entity.UserEntity
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthRemoteDataSource {

    @POST("auth/signin")
    suspend fun loginWithEmailAndPassword(@Body loginRequest: LoginRequest): retrofit2.Response<Response<UserEntity>>

    @POST("auth/signup")
    suspend fun registerWithEmailAndPassword(@Body registerRequest: RegisterRequest): retrofit2.Response<Response<UserEntity>>

}