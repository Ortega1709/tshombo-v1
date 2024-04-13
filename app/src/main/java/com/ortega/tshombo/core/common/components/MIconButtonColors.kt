package com.ortega.tshombo.core.common.components

import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import com.ortega.tshombo.core.theme.Blue
import com.ortega.tshombo.core.theme.White

@Composable
fun mIconButtonColors(): IconButtonColors {
    return IconButtonDefaults.iconButtonColors(
        contentColor = White,
        containerColor = Blue
    )
}