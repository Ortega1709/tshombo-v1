package com.ortega.tshombo.feature.auth.data.model

import com.ortega.tshombo.feature.auth.domain.entity.UserEntity

data class UserModel(
    val userId: Int,
    val username: String,
    val email: String,
    val role: RoleModel
)


fun UserModel.toEntity(): UserEntity {
    return UserEntity(userId, username, email, role.toRoleEntity())
}