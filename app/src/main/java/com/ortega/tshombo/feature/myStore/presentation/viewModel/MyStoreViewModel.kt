package com.ortega.tshombo.feature.myStore.presentation.viewModel

import android.content.Context
import android.net.Uri
import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.tshombo.core.utils.Upload
import com.ortega.tshombo.feature.myStore.domain.request.PhoneRequest
import com.ortega.tshombo.feature.myStore.domain.useCase.AddPhone
import com.ortega.tshombo.feature.myStore.domain.useCase.GetStore
import com.ortega.tshombo.feature.myStore.presentation.state.MyStoreUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MyStoreViewModel @Inject constructor(private val getStore: GetStore, private val addPhone: AddPhone): ViewModel() {

    private var _myStoreUiState = mutableStateOf(MyStoreUiState())
    val myStoreUiState = _myStoreUiState

    init {
        getStoreByUserId()
    }

    fun getStoreByUserId() {
        _myStoreUiState.value = _myStoreUiState.value.copy(loading = true)

        viewModelScope.launch {
            getStore.invoke(
                onSuccess = {
                    _myStoreUiState.value = _myStoreUiState.value.copy(loading = false, store = it)
                },
                onError = {
                    _myStoreUiState.value = _myStoreUiState.value.copy(loading = false, error = it)
                }
            )
        }
    }

    fun addPhone(
        context: Context,
        uri: Uri,
        storeId: Int,
        phoneRequest: PhoneRequest,
        loading: (Boolean) -> Unit,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        viewModelScope.launch {
            loading(true)
            val image: File = Upload().fileFromContentUri(context = context, contentUri = uri)
            addPhone.invoke(
                image = image,
                storeId = storeId,
                phoneRequest = phoneRequest,
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

}