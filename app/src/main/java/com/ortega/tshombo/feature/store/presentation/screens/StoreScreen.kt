package com.ortega.tshombo.feature.store.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import com.ortega.tshombo.core.common.components.AddFloatingButton
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.feature.store.presentation.components.BodySection
import com.ortega.tshombo.feature.store.presentation.viewModel.StoreViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreScreen(storeViewModel: StoreViewModel = hiltViewModel(), onClickAdd: () -> Unit) {
    val storesUiState by storeViewModel.storesUiState

    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = {
                    MText(
                        text = stringResource(R.string.stores),
                        fontWeight = FontWeight.Bold,
                    )
                },
                actions = {
                    IconButton(onClick = { storeViewModel.getAllStores() }) {
                        Icon(imageVector = Icons.Rounded.Refresh, contentDescription = null)
                    }
                }
            )
        },
    ) {
        BodySection(
            storesUiState = storesUiState,
            paddingValues = it,
            storeViewModel = storeViewModel
        )
    }
}