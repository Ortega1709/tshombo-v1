package com.ortega.tshombo.feature.user.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.AddFloatingButton
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.feature.user.presentation.components.BodySection
import com.ortega.tshombo.feature.user.presentation.viewModel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(userViewModel: UserViewModel, onClickAdd: () -> Unit) {

    val usersUiState by userViewModel.usersUiState

    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = {
                    MText(
                        text = stringResource(R.string.users),
                        fontWeight = FontWeight.Bold,
                    )
                },
            )
        },
        floatingActionButton = {
            AddFloatingButton { onClickAdd() }
        }
    ) { paddingValues ->
        BodySection(usersUiState = usersUiState, paddingValues = paddingValues)
    }
}