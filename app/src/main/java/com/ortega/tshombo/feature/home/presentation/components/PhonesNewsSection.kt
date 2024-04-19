package com.ortega.tshombo.feature.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.feature.home.presentation.state.PhonesNewsUiState

@Composable
fun PhonesNewsSection(phonesNewsUiState: PhonesNewsUiState) {

    if (phonesNewsUiState.loading) {
        LazyRow (
        ) {
            item { Spacer(modifier = Modifier.width(16.dp)) }
            items(10) {
                PhoneCard()
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    } else {
        LazyRow {
            item { Spacer(modifier = Modifier.width(16.dp)) }
            items(phonesNewsUiState.phones!!) {
                PhoneCard(phone = it)
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }

}