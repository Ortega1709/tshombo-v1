package com.ortega.tshombo.core.common.components

import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import com.ortega.tshombo.core.theme.Blue
import com.ortega.tshombo.core.theme.DarkGray
import com.ortega.tshombo.core.theme.White

@Composable
fun mNavigationBarItemColors(): NavigationBarItemColors {
    return NavigationBarItemDefaults.colors(
        selectedIconColor = Blue,
        selectedTextColor = Blue,
        unselectedIconColor = DarkGray,
        unselectedTextColor = DarkGray,
        indicatorColor = White
    )
}