package com.ortega.tshombo.feature.promotion.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.feature.promotion.presentation.viewModel.PromotionViewModel
import com.ortega.tshombo.feature.promotion.presentation.components.BodySection

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromotionScreen(
    promotionViewModel: PromotionViewModel = hiltViewModel(),
    onClickAdd: () -> Unit
) {

    val promotionsUiState by promotionViewModel.promotionsUiState

    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = {
                    MText(
                        text = stringResource(R.string.promotions),
                        fontWeight = FontWeight.Bold,
                    )
                },
                actions = {
                    IconButton(onClick = { promotionViewModel.getAllPromotions() }) {
                        Icon(imageVector = Icons.Rounded.Refresh, contentDescription = null)
                    }
                }
            )
        },
    ) {
        BodySection(
            promotionsUiState = promotionsUiState,
            paddingValues = it,
            promotionViewModel = promotionViewModel,
        )
    }
}