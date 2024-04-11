package com.ortega.tshombo.core.common.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.ortega.tshombo.core.theme.fontFamily

@Composable
fun MText(text: String, modifier: Modifier = Modifier, fontWeight: FontWeight = FontWeight.Medium) {
    Text(modifier = modifier, text = text, fontFamily = fontFamily, fontWeight = fontWeight)
}