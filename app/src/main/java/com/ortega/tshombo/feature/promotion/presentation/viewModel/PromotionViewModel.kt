package com.ortega.tshombo.feature.promotion.presentation.viewModel

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.tshombo.core.utils.Upload
import com.ortega.tshombo.feature.promotion.domain.request.PromotionRequest
import com.ortega.tshombo.feature.promotion.domain.useCase.AddPromotion
import com.ortega.tshombo.feature.promotion.domain.useCase.DeletePromotion
import com.ortega.tshombo.feature.promotion.domain.useCase.GetPromotions
import com.ortega.tshombo.feature.promotion.presentation.state.PromotionsUiState
import com.ortega.tshombo.feature.user.presentation.state.UsersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.File
import java.lang.Error
import javax.inject.Inject

@HiltViewModel
class PromotionViewModel @Inject constructor(
    private val addPromotion: AddPromotion,
    private val getPromotions: GetPromotions,
    private val deletePromotion: DeletePromotion
) : ViewModel() {

    private var _promotionsUiState = mutableStateOf(PromotionsUiState())
    val promotionsUiState = _promotionsUiState

    init {
        getAllPromotions()
    }

    fun addPromotion(
        context: Context,
        uri: Uri,
        storeId: Int,
        promotionRequest: PromotionRequest,
        loading: (Boolean) -> Unit,
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
    ) {

        viewModelScope.launch {
            loading(true)
            val image: File = Upload().fileFromContentUri(context = context, uri)
            addPromotion.invoke(
                image = image,
                storeId = storeId,
                promotionRequest = promotionRequest,
                onSuccess = {
                    loading(false)
                    onSuccess()
                },
                onError = {
                    loading(false)
                    onError(it)
                },
            )
        }
    }

    fun getAllPromotions() {

        _promotionsUiState.value = _promotionsUiState.value.copy(loading = true)

        viewModelScope.launch {
            getPromotions.invoke(
                onSuccess = {
                    _promotionsUiState.value =
                        _promotionsUiState.value.copy(loading = false, promotions = it)
                },
                onError = {
                    _promotionsUiState.value =
                        _promotionsUiState.value.copy(loading = false, error = it)
                }
            )
        }
    }

    fun deletePromotionById(promotionId: Int) {

        _promotionsUiState.value = _promotionsUiState.value.copy(loading = true)

        viewModelScope.launch {
            deletePromotion.invoke(
                promotionId = promotionId,
                onSuccess = {
                    getAllPromotions()
                },
                onError = {
                    getAllPromotions()
                }
            )
        }

    }

}