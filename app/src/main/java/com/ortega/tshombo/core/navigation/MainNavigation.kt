package com.ortega.tshombo.core.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ortega.tshombo.AuthActivity
import com.ortega.tshombo.NotificationActivity
import com.ortega.tshombo.feature.favorite.presentation.screens.FavoriteScreen
import com.ortega.tshombo.feature.home.presentation.screens.HomeScreen
import com.ortega.tshombo.feature.home.presentation.viewModel.HomeViewModel
import com.ortega.tshombo.feature.myStore.presentation.screens.MyStoreScreen

@Composable
fun MainNavigation(navController: NavHostController) {

    val context = LocalContext.current

    val homeViewModel: HomeViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = MainScreens.HOME.name) {
        composable(route = MainScreens.HOME.name) {
            HomeScreen(
                homeViewModel = homeViewModel,
                onClickNotification = {
                    val intent = Intent(context, NotificationActivity::class.java)
                    context.startActivity(intent)
                },
                onClickLogout = {
                    val intent = Intent(context, AuthActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    context.startActivity(intent)
                }
            )
        }
        composable(route = MainScreens.FAVORITE.name) {
            FavoriteScreen()
        }
        composable(route = MainScreens.MY_STORE.name) {
            MyStoreScreen()
        }
    }
}