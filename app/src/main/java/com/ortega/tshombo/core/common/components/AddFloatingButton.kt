package com.ortega.tshombo.core.common.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.ortega.tshombo.core.theme.Blue
import com.ortega.tshombo.core.theme.White

@Composable
fun AddFloatingButton(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick, containerColor = Blue, contentColor = White) {
        Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
    }
}