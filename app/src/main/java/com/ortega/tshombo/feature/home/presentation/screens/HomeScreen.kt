package com.ortega.tshombo.feature.home.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(onClickNotification: () -> Unit) {
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

    }
}