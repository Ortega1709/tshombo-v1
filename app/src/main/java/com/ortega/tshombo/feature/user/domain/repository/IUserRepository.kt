package com.ortega.tshombo.feature.user.domain.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.user.domain.entity.UserEntity
import retrofit2.Response

interface IUserRepository {

    suspend fun getAllUsers(): Response<Res<List<UserEntity>>>

}