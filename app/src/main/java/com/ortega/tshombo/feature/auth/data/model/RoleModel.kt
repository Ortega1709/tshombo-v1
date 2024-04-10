package com.ortega.tshombo.feature.auth.data.model

import com.ortega.tshombo.feature.auth.domain.entity.RoleEntity

data class RoleModel(val userId: Int, val name: String)

fun RoleModel.toRoleEntity(): RoleEntity {
    return RoleEntity(userId, name)
}