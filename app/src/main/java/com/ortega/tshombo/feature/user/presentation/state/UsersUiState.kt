package com.ortega.tshombo.feature.user.presentation.state

import com.ortega.tshombo.feature.user.domain.entity.UserEntity

data class UsersUiState(
    val loading: Boolean = false,
    val users: List<UserEntity> = emptyList(),
    val error: String = ""
)