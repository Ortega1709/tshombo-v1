package com.ortega.tshombo.feature.auth.domain.request

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String,
    val role: String = "USER"
)
