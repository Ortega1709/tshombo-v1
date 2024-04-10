package com.ortega.tshombo.feature.auth.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.tshombo.feature.auth.domain.entity.UserEntity
import com.ortega.tshombo.feature.auth.domain.useCase.UserLogin
import com.ortega.tshombo.feature.auth.domain.useCase.UserRegister
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userLogin: UserLogin,
    private val userRegister: UserRegister
) : ViewModel() {

    private val _state = mutableStateOf(AuthState())
    val state: State<AuthState> = _state

    fun login(email: String, password: String) {
        _state.value = AuthState(isLoading = true)

        viewModelScope.launch {
            userLogin.invoke(
                email = email,
                password = password,
                onSuccess = { _state.value = AuthState(isLoading = false, user = it) },
                onError = {
                    _state.value = AuthState(isLoading = false, error = it)
                    Log.d("REGISTER", it)
                }
            )
        }
    }

    fun register(name: String, email: String, password: String) {
        _state.value = AuthState(isLoading = true)

        viewModelScope.launch {
            userRegister.invoke(
                name = name,
                email = email,
                password = password,
                onSuccess = { _state.value = AuthState(isLoading = false, user = it) },
                onError = {
                    _state.value = AuthState(isLoading = false, error = it)
                }
            )
        }
    }

}

data class AuthState(
    val isLoading: Boolean = false,
    val user: UserEntity? = null,
    val error: String = ""
)