package com.ortega.tshombo.feature.user.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.tshombo.core.utils.Resource
import com.ortega.tshombo.feature.user.domain.entity.UserEntity
import com.ortega.tshombo.feature.user.domain.request.UserRequest
import com.ortega.tshombo.feature.user.domain.useCase.AddUser
import com.ortega.tshombo.feature.user.domain.useCase.GetUsers
import com.ortega.tshombo.feature.user.presentation.state.UsersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsers: GetUsers,
    private val addUser: AddUser
) : ViewModel() {

    private var _usersUiState = mutableStateOf(UsersUiState())
    val usersUiState = _usersUiState

    init { getAllUsers() }

    fun addUser(
        userRequest: UserRequest,
        loading: (Boolean) -> Unit,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            loading(true)
            addUser.invoke(
                userRequest = userRequest,
                onSuccess = {
                   loading(false)
                   onSuccess()
                },
                onError = {
                   loading(false)
                   onError(it)
                }
            )
        }
    }

    fun getAllUsers() {

        _usersUiState.value = _usersUiState.value.copy(loading = true)

        viewModelScope.launch {
            getUsers.invoke(
                onSuccess = {
                    _usersUiState.value = _usersUiState.value.copy(loading = false, users = it)
                },
                onError = {
                    _usersUiState.value = _usersUiState.value.copy(loading = false, error = it)
                }
            )
        }
    }

}