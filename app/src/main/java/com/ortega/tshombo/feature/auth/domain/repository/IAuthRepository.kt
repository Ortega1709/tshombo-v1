package com.ortega.tshombo.feature.auth.domain.repository

import com.ortega.tshombo.core.common.response.Response
import com.ortega.tshombo.feature.auth.domain.entity.UserEntity

interface IAuthRepository {

    suspend fun loginWithEmailAndPassword(email: String, password: String): retrofit2.Response<Response<UserEntity>>
    suspend fun registerWithEmailAndPassword(username: String, password: String, email: String): retrofit2.Response<Response<UserEntity>>

}