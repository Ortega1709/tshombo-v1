package com.ortega.tshombo.feature.auth.domain.entity


data class UserEntity(
    val userId: Int,
    val username: String,
    val email: String,
    val role: RoleEntity
)
