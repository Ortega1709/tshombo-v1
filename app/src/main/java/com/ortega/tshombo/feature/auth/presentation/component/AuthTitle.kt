package com.ortega.tshombo.feature.auth.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.ortega.tshombo.core.theme.fontFamily


@Composable
fun AuthTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineLarge,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    )
}