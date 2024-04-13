package com.ortega.tshombo.core.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ortega.tshombo.AdminActivity
import com.ortega.tshombo.AuthActivity
import com.ortega.tshombo.MainActivity
import com.ortega.tshombo.feature.auth.presentation.screen.LoginScreen
import com.ortega.tshombo.feature.auth.presentation.screen.RegisterScreen
import com.ortega.tshombo.feature.auth.presentation.viewModel.AuthViewModel

@Composable
fun TshomboNavigation(navController: NavHostController) {

    val context = LocalContext.current
    val authViewModel: AuthViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = AuthScreens.LOGIN.name) {
        composable(route = AuthScreens.LOGIN.name) {
            LoginScreen(
                authViewModel = authViewModel,
                onLoginSuccess = {
                    if (it.role.name == "ADMIN") {
                        val intent = Intent(context, AdminActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        context.startActivity(intent)
                    } else {
                        val intent = Intent(context, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        context.startActivity(intent)
                    }
                },
                onClickCreateAccount = { navController.navigate(AuthScreens.REGISTER.name) }
            )
        }

        composable(route = AuthScreens.REGISTER.name) {
            RegisterScreen(
                authViewModel = authViewModel,
                onRegisterSuccess = {
                    val intent = Intent(context, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    context.startActivity(intent)
                },
                onClickBack = { navController.popBackStack() }
            )
        }
    }
}

