package com.ortega.tshombo.feature.user.domain.entity

data class UserEntity(
    val userId: Int,
    val username: String,
    val email: String,
    val password: String,
    val role: RoleEntity
)
