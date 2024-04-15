package com.ortega.tshombo.feature.auth.domain.request

data class LoginRequest(
    val email: String,
    val password: String
)
