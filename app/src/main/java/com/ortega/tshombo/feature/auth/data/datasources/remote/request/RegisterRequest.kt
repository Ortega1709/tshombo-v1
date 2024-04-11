package com.ortega.tshombo.feature.auth.data.datasources.remote.request

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String,
    val role: String = "USER"
)
