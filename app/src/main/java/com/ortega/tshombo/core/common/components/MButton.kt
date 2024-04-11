package com.ortega.tshombo.core.common.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ortega.tshombo.core.theme.fontFamily

@Composable
fun MButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(modifier = modifier.fillMaxWidth(), onClick = onClick) {
        Text(text = text, fontFamily = fontFamily)
    }
}