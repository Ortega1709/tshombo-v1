package com.ortega.tshombo.core.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ortega.tshombo.AuthActivity
import com.ortega.tshombo.MainActivity
import com.ortega.tshombo.PromotionActivity
import com.ortega.tshombo.StoreActivity
import com.ortega.tshombo.UserActivity
import com.ortega.tshombo.feature.promotion.presentation.screens.PromotionScreen
import com.ortega.tshombo.feature.store.presentation.screens.StoreScreen
import com.ortega.tshombo.feature.user.presentation.screens.UserScreen
import com.ortega.tshombo.feature.user.presentation.viewModel.UserViewModel

@Composable
fun AdminNavigation(navController: NavHostController) {
    val context = LocalContext.current

    val userViewModel: UserViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = AdminScreens.MANAGE_USER.name) {
        composable(route = AdminScreens.MANAGE_USER.name) {
            UserScreen(
                userViewModel = userViewModel,
                onClickAdd = {
                    val intent = Intent(context, UserActivity::class.java)
                    context.startActivity(intent)
                },
                onClickLogout = {
                    val intent = Intent(context, AuthActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    context.startActivity(intent)
                }
            )
        }
        composable(route = AdminScreens.MANAGE_PROMOTION.name) {
            PromotionScreen(onClickAdd = {
                val intent = Intent(context, PromotionActivity::class.java)
                context.startActivity(intent)
            })
        }
        composable(route = AdminScreens.MANAGE_STORE.name) {
            StoreScreen(onClickAdd = {
                val intent = Intent(context, StoreActivity::class.java)
                context.startActivity(intent)
            })

        }
    }

}