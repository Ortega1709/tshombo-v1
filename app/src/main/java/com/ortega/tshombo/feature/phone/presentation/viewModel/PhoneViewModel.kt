package com.ortega.tshombo.feature.phone.presentation.viewModel

import android.adservices.adid.AdId
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.tshombo.feature.phone.domain.useCase.GetPhoneById
import com.ortega.tshombo.feature.phone.presentation.state.PhoneUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhoneViewModel @Inject constructor(private val getPhoneById: GetPhoneById) : ViewModel() {

    private var _phoneUiState = mutableStateOf(PhoneUiState())
    val phoneUiState = _phoneUiState

    fun getPhoneById(phoneId: Int) {

        _phoneUiState.value = _phoneUiState.value.copy(loading = true)
        viewModelScope.launch {

            getPhoneById.invoke(
                phoneId = phoneId,
                onSuccess = {
                    _phoneUiState.value = _phoneUiState.value.copy(loading = false, phone = it)
                },
                onError = {
                    _phoneUiState.value = _phoneUiState.value.copy(loading = false, error = it)
                },
            )

        }
    }

}

