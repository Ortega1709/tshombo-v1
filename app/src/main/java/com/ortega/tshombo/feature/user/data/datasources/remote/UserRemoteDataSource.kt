package com.ortega.tshombo.feature.user.data.datasources.remote

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.user.domain.entity.UserEntity
import com.ortega.tshombo.feature.user.domain.request.UserRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserRemoteDataSource {

    @GET("users")
    suspend fun getAllUsers(): Response<Res<List<UserEntity>>>
    @POST("auth/signup")
    suspend fun addUser(@Body userRequest: UserRequest): Response<Res<UserEntity>>
    @DELETE("users/{userId}")
    suspend fun deleteUser(@Path("userId") userId: Int): Response<Res<UserEntity>>

}