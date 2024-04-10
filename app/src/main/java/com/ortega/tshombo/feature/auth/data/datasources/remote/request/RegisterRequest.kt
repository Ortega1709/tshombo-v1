package com.ortega.tshombo.feature.auth.data.datasources.remote.request

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)
