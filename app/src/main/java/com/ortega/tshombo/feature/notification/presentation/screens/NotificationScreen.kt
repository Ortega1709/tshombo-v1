package com.ortega.tshombo.feature.notification.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.common.components.NavigationIconButton

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotificationScreen(onClickBack: () -> Unit) {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                navigationIcon = {
                    NavigationIconButton(onClick = onClickBack)
                },
                title = {
                    MText(
                        text = stringResource(R.string.notifications),
                        fontWeight = FontWeight.Bold,
                    )
                },
            )
        }
    ) {

    }
}