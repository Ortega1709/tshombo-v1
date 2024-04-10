package com.ortega.tshombo.core.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ortega.tshombo.feature.auth.presentation.screen.LoginScreen
import com.ortega.tshombo.feature.auth.presentation.screen.RegisterScreen
import com.ortega.tshombo.feature.auth.presentation.viewModel.AuthViewModel

@Composable
fun TshomboNavigation(navController: NavHostController) {

    val authViewModel: AuthViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screens.LOGIN.name) {
        composable(route = Screens.LOGIN.name) {
            LoginScreen(
                authViewModel = authViewModel,
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

