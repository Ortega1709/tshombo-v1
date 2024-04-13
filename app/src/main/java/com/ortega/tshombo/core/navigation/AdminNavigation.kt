package com.ortega.tshombo.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ortega.tshombo.feature.promotion.presentation.screens.PromotionScreen
import com.ortega.tshombo.feature.store.presentation.screens.StoreScreen
import com.ortega.tshombo.feature.user.presentation.screens.UserScreen

@Composable
fun AdminNavigation(navController: NavHostController) {

    val context = LocalContext.current

    NavHost(navController = navController, startDestination = AdminScreens.MANAGE_USER.name) {
        composable(route = AdminScreens.MANAGE_USER.name) {
            UserScreen()
        }
        composable(route = AdminScreens.MANAGE_PROMOTION.name) {
            PromotionScreen()
        }
        composable(route = AdminScreens.MANAGE_STORE.name) {
            StoreScreen()
        }
    }

}