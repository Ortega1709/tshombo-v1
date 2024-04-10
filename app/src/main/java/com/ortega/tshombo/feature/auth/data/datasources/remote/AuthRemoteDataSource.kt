package com.ortega.tshombo.feature.auth.data.datasources.remote

import com.ortega.tshombo.core.common.response.Response
import com.ortega.tshombo.feature.auth.data.datasources.remote.request.LoginRequest
import com.ortega.tshombo.feature.auth.data.datasources.remote.request.RegisterRequest
import com.ortega.tshombo.feature.auth.data.model.UserModel
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthRemoteDataSource {

    @POST("auth/signin")
    suspend fun loginWithEmailAndPassword(@Body loginRequest: LoginRequest): Response<UserModel>

    @POST("auth/signup")
    suspend fun registerWithEmailAndPassword(@Body registerRequest: RegisterRequest): Response<UserModel>

}