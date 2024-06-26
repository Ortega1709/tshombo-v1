package com.ortega.tshombo.feature.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.feature.home.presentation.state.StoresUiState

@Composable
fun StoresSection(storesUiState: StoresUiState) {

    if (storesUiState.loading) {
        LazyRow {
            item { Spacer(modifier = Modifier.width(16.dp)) }
            items(10) {
                StoreCard()
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    } else {
        LazyRow {
            item { Spacer(modifier = Modifier.width(16.dp)) }
            items(storesUiState.stores!!) {
                StoreCard(store = it)
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}