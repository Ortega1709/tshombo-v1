package com.ortega.tshombo.core.common.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.ortega.tshombo.core.theme.Blue

@Composable
fun NavigationIconButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null, tint = Blue)
    }
}