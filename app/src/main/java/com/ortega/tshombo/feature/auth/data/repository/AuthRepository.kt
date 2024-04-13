package com.ortega.tshombo.feature.auth.data.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.auth.data.datasources.remote.AuthRemoteDataSource
import com.ortega.tshombo.feature.auth.data.datasources.remote.request.LoginRequest
import com.ortega.tshombo.feature.auth.data.datasources.remote.request.RegisterRequest
import com.ortega.tshombo.feature.auth.domain.entity.UserEntity
import com.ortega.tshombo.feature.auth.domain.repository.IAuthRepository
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource
) : IAuthRepository {

    override suspend fun loginWithEmailAndPassword(email: String, password: String): retrofit2.Response<Res<UserEntity>> {
        val loginRequest = LoginRequest(email = email, password = password)
        return authRemoteDataSource.loginWithEmailAndPassword(loginRequest)
    }

    override suspend fun registerWithEmailAndPassword(
        username: String,
        password: String,
        email: String
    ): retrofit2.Response<Res<UserEntity>> {
        val registerRequest = RegisterRequest(username = username, password = password, email = email)
        return authRemoteDataSource.registerWithEmailAndPassword(registerRequest)
    }

}