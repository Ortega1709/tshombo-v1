package com.ortega.tshombo.features.auth.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AuthSubtitle(text: String, modifier: Modifier = Modifier) {
    Text(modifier = modifier, text = text)
}