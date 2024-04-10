package com.ortega.tshombo.feature.auth.domain.repository

import com.ortega.tshombo.feature.auth.domain.entity.UserEntity

interface IAuthRepository {

    suspend fun loginWithEmailAndPassword(email: String, password: String): UserEntity
    suspend fun registerWithEmailAndPassword(name: String, password: String, email: String): UserEntity

}