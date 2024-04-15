package com.ortega.tshombo.feature.store.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.tshombo.feature.store.domain.useCase.AddStore
import com.ortega.tshombo.feature.store.domain.useCase.GetStores
import com.ortega.tshombo.feature.store.presentation.state.StoresUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val getStores: GetStores,
    private val addStore: AddStore
): ViewModel() {

    private val _storesUiState = mutableStateOf(StoresUiState())
    val storesUiState = _storesUiState

    init { getAllStores() }

    fun getAllStores() {

        _storesUiState.value = _storesUiState.value.copy(loading = true)

        viewModelScope.launch {
            getStores.invoke(
                onSuccess = {
                    _storesUiState.value = _storesUiState.value.copy(loading = false, users = it)
                },
                onError = {
                    _storesUiState.value = _storesUiState.value.copy(loading = false, error = it)
                }
            )
        }
    }

    fun deleteByStoreId(storeId: Int) {

    }

}

