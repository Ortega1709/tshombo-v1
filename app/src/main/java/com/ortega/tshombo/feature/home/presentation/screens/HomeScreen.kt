package com.ortega.tshombo.feature.home.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.feature.home.presentation.components.PhoneCard
import com.ortega.tshombo.feature.home.presentation.components.PhonesNewsSection
import com.ortega.tshombo.feature.home.presentation.components.PhonesSection
import com.ortega.tshombo.feature.home.presentation.components.PromotionSection
import com.ortega.tshombo.feature.home.presentation.components.SeeMoreSection
import com.ortega.tshombo.feature.home.presentation.components.StoreCard
import com.ortega.tshombo.feature.home.presentation.components.StoresSection
import com.ortega.tshombo.feature.home.presentation.viewModel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel, onClickNotification: () -> Unit) {

    val phonesUiState by homeViewModel.phonesUiState
    val phonesNewsUiState by homeViewModel.phonesNewsUiState
    val storesUiState by homeViewModel.storesUiState


    Scaffold(
        topBar = {
            LargeTopAppBar(
                actions = {
                    IconButton(onClick = onClickNotification) {
                        Icon(imageVector = Icons.Rounded.Notifications, contentDescription = null)
                    }
                },
                title = {
                    MText(
                        modifier = Modifier.padding(end = 16.dp),
                        text = stringResource(R.string.find_right_phone),
                        fontWeight = FontWeight.Bold
                    )
                },
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues = it)
        ) {

            PromotionSection(images = listOf())

            SeeMoreSection(text = stringResource(R.string.recommanded), onClickMore = {})
            
            PhonesSection(phonesUiState = phonesUiState)

            SeeMoreSection(text = stringResource(R.string.news), onClickMore = {})

            PhonesNewsSection(phonesNewsUiState = phonesNewsUiState)

            SeeMoreSection(text = stringResource(R.string.stores), onClickMore = {})

            StoresSection(storesUiState = storesUiState)

            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}