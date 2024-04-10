package com.ortega.tshombo.feature.auth.data.repository

import com.ortega.tshombo.feature.auth.data.datasources.remote.AuthRemoteDataSource
import com.ortega.tshombo.feature.auth.data.datasources.remote.request.LoginRequest
import com.ortega.tshombo.feature.auth.data.datasources.remote.request.RegisterRequest
import com.ortega.tshombo.feature.auth.data.model.toEntity
import com.ortega.tshombo.feature.auth.domain.entity.UserEntity
import com.ortega.tshombo.feature.auth.domain.repository.IAuthRepository
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource
) : IAuthRepository {

    override suspend fun loginWithEmailAndPassword(email: String, password: String): UserEntity {
        val loginRequest = LoginRequest(email = email, password = password)
        return authRemoteDataSource.loginWithEmailAndPassword(loginRequest).data.toEntity()
    }

    override suspend fun registerWithEmailAndPassword(
        name: String,
        password: String,
        email: String
    ): UserEntity {
        val registerRequest = RegisterRequest(name = name, password = password, email = email)
        return authRemoteDataSource.registerWithEmailAndPassword(registerRequest).data.toEntity()
    }

}