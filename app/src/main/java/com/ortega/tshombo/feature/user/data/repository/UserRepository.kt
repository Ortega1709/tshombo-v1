package com.ortega.tshombo.feature.user.data.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.user.data.datasources.remote.UserRemoteDataSource
import com.ortega.tshombo.feature.user.domain.entity.UserEntity
import com.ortega.tshombo.feature.user.domain.repository.IUserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val userRemoteDataSource: UserRemoteDataSource) : IUserRepository {
    override suspend fun getAllUsers(): Response<Res<List<UserEntity>>> {
        return userRemoteDataSource.getAllUsers()
    }
}