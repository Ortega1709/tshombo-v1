package com.ortega.tshombo.feature.auth.presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ortega.tshombo.core.theme.fontFamily

@Composable
fun AuthSubtitle(text: String, modifier: Modifier = Modifier) {
    Text(modifier = modifier, text = text, fontFamily = fontFamily)
}