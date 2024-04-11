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

    fun login(
        email: String,
        password: String,
        loading: (Boolean) -> Unit,
        onSuccess: (UserEntity) -> Unit,
        onError: (String) -> Unit,
    ) {

        loading(true)

        viewModelScope.launch {
            userLogin.invoke(
                email = email,
                password = password,
                onSuccess = {
                    loading(false)
                    onSuccess(it)
                },
                onError = {
                    loading(false)
                    onError(it)
                }
            )
        }
    }

    fun register(
        name: String,
        email: String,
        password: String,
        loading: (Boolean) -> Unit,
        onSuccess: (UserEntity) -> Unit,
        onError: (String) -> Unit,
    ) {

        loading(true)

        viewModelScope.launch {
            userRegister.invoke(
                name = name,
                email = email,
                password = password,
                onSuccess = {
                    loading(false)
                    onSuccess(it)
                },
                onError = {
                    loading(false)
                    onError(it)
                }
            )
        }
    }

}
