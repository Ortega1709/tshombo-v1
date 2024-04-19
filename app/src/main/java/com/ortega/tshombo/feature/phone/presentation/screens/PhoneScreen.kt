package com.ortega.tshombo.feature.phone.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ortega.tshombo.core.common.components.ErrorFound
import com.ortega.tshombo.core.common.components.Loading
import com.ortega.tshombo.core.common.components.NavigationIconButton
import com.ortega.tshombo.core.theme.DarkGray
import com.ortega.tshombo.core.theme.White
import com.ortega.tshombo.feature.phone.presentation.viewModel.PhoneViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneScreen(
    phoneViewModel: PhoneViewModel = hiltViewModel(),
    phoneId: Int,
    onClickBack: () -> Unit
) {

    LaunchedEffect(Unit) {
        phoneViewModel.getPhoneById(phoneId)
    }

    val phoneUiState by phoneViewModel.phoneUiState

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    NavigationIconButton(onClick = onClickBack)
                },
                title = {

                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Rounded.FavoriteBorder, contentDescription = null)
                    }
                }
            )
        }
    ) {
        if (phoneUiState.loading) Loading(paddingValues = it)
        else {
            if (phoneUiState.phone == null) {
                ErrorFound(onClickRetry = { phoneViewModel.getPhoneById(phoneId) }, paddingValues = it)
            } else {

            }
        }

    }
}