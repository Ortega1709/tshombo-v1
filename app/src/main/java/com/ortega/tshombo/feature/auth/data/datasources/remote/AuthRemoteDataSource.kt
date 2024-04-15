package com.ortega.tshombo.feature.auth.data.datasources.remote

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.auth.domain.request.LoginRequest
import com.ortega.tshombo.feature.auth.domain.request.RegisterRequest
import com.ortega.tshombo.feature.auth.domain.entity.UserEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthRemoteDataSource {

    @POST("auth/signin")
    suspend fun loginWithEmailAndPassword(@Body loginRequest: LoginRequest): Response<Res<UserEntity>>

    @POST("auth/signup")
    suspend fun registerWithEmailAndPassword(@Body registerRequest: RegisterRequest): Response<Res<UserEntity>>

}