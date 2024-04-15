package com.ortega.tshombo.core.common.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MTextButton(text: String, onClick: () -> Unit, loading: Boolean = false) {
    TextButton(onClick = onClick) {
        if (loading) {
            CircularProgressIndicator(modifier = Modifier.size(30.dp))
        } else {
            MText(text = text)
        }
    }
}