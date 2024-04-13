package com.ortega.tshombo.core.common.components

import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun MTextButton(text: String, onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        MText(text = text)
    }
}