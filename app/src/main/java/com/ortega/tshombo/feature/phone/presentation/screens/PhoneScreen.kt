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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.core.common.components.NavigationIconButton
import com.ortega.tshombo.core.theme.DarkGray
import com.ortega.tshombo.core.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneScreen(onClickBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    NavigationIconButton(onClick = onClickBack)
                },
                title = { Text(text = "") },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Rounded.FavoriteBorder, contentDescription = null)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
        ) {
            Surface (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                color = DarkGray
            ) {

            }

            Surface (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(all = 16.dp),
                shape = RoundedCornerShape(12.dp),
                color = White
            ) {

            }

        }
    }
}