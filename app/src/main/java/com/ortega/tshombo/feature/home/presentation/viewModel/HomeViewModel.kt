package com.ortega.tshombo.feature.home.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.tshombo.feature.home.domain.useCase.GetPhones
import com.ortega.tshombo.feature.home.domain.useCase.GetPhonesByNews
import com.ortega.tshombo.feature.home.domain.useCase.GetStores
import com.ortega.tshombo.feature.home.presentation.state.PhonesNewsUiState
import com.ortega.tshombo.feature.home.presentation.state.PhonesUiState
import com.ortega.tshombo.feature.home.presentation.state.StoresUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPhones: GetPhones,
    private val phonesByNews: GetPhonesByNews,
    private val getStores: GetStores
) : ViewModel() {

    private var _phonesUiState = mutableStateOf(PhonesUiState())
    val phonesUiState = _phonesUiState

    private var _phonesNewsUiState = mutableStateOf(PhonesNewsUiState())
    val phonesNewsUiState = _phonesNewsUiState

    private var _storesUiState = mutableStateOf(StoresUiState())
    val storesUiState = _storesUiState


    init {
        getStores()
        getPhones()
        getPhonesByNews()
    }

    fun getStores() {

        _storesUiState.value = _storesUiState.value.copy(loading = true)

        viewModelScope.launch {
            getStores.invoke(
                onSuccess = {
                    _storesUiState.value = _storesUiState.value.copy(loading = false, stores = it)
                },
                onError = {
                    _storesUiState.value = _storesUiState.value.copy(loading = false, error = it)
                }
            )
        }
    }

    fun getPhonesByNews() {

        _phonesNewsUiState.value = _phonesNewsUiState.value.copy(loading = true)
        viewModelScope.launch {
            phonesByNews.invoke(
                onSuccess = {
                    _phonesNewsUiState.value =
                        _phonesNewsUiState.value.copy(loading = false, phones = it)
                },
                onError = {
                    _phonesNewsUiState.value =
                        _phonesNewsUiState.value.copy(loading = false, error = it)
                },
            )
        }
    }

    fun getPhones() {

        _phonesUiState.value = _phonesUiState.value.copy(loading = true)
        viewModelScope.launch {
            getPhones.invoke(
                onSuccess = {
                    _phonesUiState.value = _phonesUiState.value.copy(loading = false, phones = it)
                },
                onError = {
                    _phonesUiState.value = _phonesUiState.value.copy(loading = false, error = it)
                }
            )
        }
    }

}
