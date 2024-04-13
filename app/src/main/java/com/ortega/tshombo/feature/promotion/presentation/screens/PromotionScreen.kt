package com.ortega.tshombo.feature.promotion.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.AddFloatingButton
import com.ortega.tshombo.core.common.components.MText

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromotionScreen(onClickAdd: () -> Unit) {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = {
                    MText(
                        text = stringResource(R.string.promotions),
                        fontWeight = FontWeight.Bold,
                    )
                },
            )
        },
        floatingActionButton = {
            AddFloatingButton { onClickAdd() }
        }
    ) {

    }
}