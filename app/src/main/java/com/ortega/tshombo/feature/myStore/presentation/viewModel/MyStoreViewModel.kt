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
import com.ortega.tshombo.feature.myStore.domain.useCase.DeletePhone
import com.ortega.tshombo.feature.myStore.domain.useCase.GetPhonesByStore
import com.ortega.tshombo.feature.myStore.domain.useCase.GetStore
import com.ortega.tshombo.feature.myStore.domain.useCase.UpdatePhone
import com.ortega.tshombo.feature.myStore.presentation.state.MyStorePhoneUiState
import com.ortega.tshombo.feature.myStore.presentation.state.MyStoreUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MyStoreViewModel @Inject constructor(
    private val getStore: GetStore,
    private val addPhone: AddPhone,
    private val getPhonesByStore: GetPhonesByStore,
    private val deletePhone: DeletePhone,
    private val updatePhone: UpdatePhone
) : ViewModel() {

    private var _myStoreUiState = mutableStateOf(MyStoreUiState())
    private var _myStorePhoneUiState = mutableStateOf(MyStorePhoneUiState())
    val myStoreUiState = _myStoreUiState
    val myStorePhoneUiState = _myStorePhoneUiState

    init {
        getStoreByUserId()
    }

    private fun getPhonesByStoreId(storeId: Int) {
        _myStorePhoneUiState.value = _myStorePhoneUiState.value.copy(loading = true)

        viewModelScope.launch {
            getPhonesByStore.invoke(
                storeId = storeId,
                onSuccess = {
                    _myStorePhoneUiState.value =
                        _myStorePhoneUiState.value.copy(loading = false, phone = it)
                },
                onError = {
                    _myStorePhoneUiState.value =
                        _myStorePhoneUiState.value.copy(loading = false, error = it)
                }
            )
        }
    }

    fun getStoreByUserId() {
        _myStoreUiState.value = _myStoreUiState.value.copy(loading = true)

        viewModelScope.launch {
            getStore.invoke(
                onSuccess = {
                    _myStoreUiState.value = _myStoreUiState.value.copy(loading = false, store = it)
                    getPhonesByStoreId(it.storeId)
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

    fun updatePhoneById(
        storeId: Int,
        phoneRequest: PhoneRequest,
        loading: (Boolean) -> Unit,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        viewModelScope.launch {
            loading(true)
            updatePhone.invoke(
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

    fun deletePhoneById(phoneId: Int) {

        _myStoreUiState.value = _myStoreUiState.value.copy(loading = true)

        viewModelScope.launch {
            deletePhone.invoke(
                phoneId = phoneId,
                onSuccess = {
                    getStoreByUserId()
                },
                onError = {
                    getStoreByUserId()
                }
            )
        }

    }

}