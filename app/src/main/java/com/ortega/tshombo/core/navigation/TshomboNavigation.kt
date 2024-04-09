package com.ortega.tshombo.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ortega.tshombo.features.auth.presentation.screens.LoginScreen
import com.ortega.tshombo.features.auth.presentation.screens.RegisterScreen

@Composable
fun TshomboNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.LOGIN.name) {
        composable(route = Screens.LOGIN.name) {
            LoginScreen(
                onClickCreateAccount = { navController.navigate(Screens.REGISTER.name) }
            )
        }

        composable(route = Screens.REGISTER.name) {
            RegisterScreen(
                onClickBack = { navController.popBackStack() }
            )
        }
    }
}

