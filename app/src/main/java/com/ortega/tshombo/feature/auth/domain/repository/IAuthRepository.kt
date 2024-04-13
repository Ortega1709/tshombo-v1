package com.ortega.tshombo.feature.auth.domain.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.auth.domain.entity.UserEntity
import retrofit2.Response

interface IAuthRepository {

    suspend fun loginWithEmailAndPassword(email: String, password: String): Response<Res<UserEntity>>
    suspend fun registerWithEmailAndPassword(username: String, password: String, email: String): Response<Res<UserEntity>>

}