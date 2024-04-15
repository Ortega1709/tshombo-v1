package com.ortega.tshombo.feature.user.domain.request

data class UserRequest(
    val username: String,
    val email: String,
    val password: String,
    val role: String = "ADMIN"
)
