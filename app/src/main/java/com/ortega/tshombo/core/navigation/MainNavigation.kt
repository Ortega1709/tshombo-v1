package com.ortega.tshombo.core.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ortega.tshombo.NotificationActivity
import com.ortega.tshombo.feature.favorite.presentation.screens.FavoriteScreen
import com.ortega.tshombo.feature.home.presentation.screens.HomeScreen
import com.ortega.tshombo.feature.store.presentation.screens.StoreScreen

@Composable
fun MainNavigation(navController: NavHostController) {

    val context = LocalContext.current

    NavHost(navController = navController, startDestination = MainScreens.HOME.name) {
        composable(route = MainScreens.HOME.name) {
            HomeScreen(
                onClickNotification = {
                    val intent = Intent(context, NotificationActivity::class.java)
                    context.startActivity(intent)
                },
            )
        }
        composable(route = MainScreens.FAVORITE.name) {
            FavoriteScreen()
        }
        composable(route = MainScreens.MY_STORE.name) {
            StoreScreen()
        }
    }
}