package com.ortega.tshombo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.common.components.mNavigationBarItemColors
import com.ortega.tshombo.core.navigation.MainNavigation
import com.ortega.tshombo.core.navigation.MainScreens
import com.ortega.tshombo.core.theme.Blue
import com.ortega.tshombo.core.theme.DarkGray
import com.ortega.tshombo.core.theme.TshomboTheme
import com.ortega.tshombo.core.theme.White
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TshomboTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(navController = rememberNavController())
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {


    val context = LocalContext.current

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = White
            ) {
                NavigationBarItem(
                    colors = mNavigationBarItemColors(),
                    selected = currentRoute == MainScreens.HOME.name,
                    label = { MText(text = stringResource(R.string.home)) },
                    onClick = {
                        navController.navigate(MainScreens.HOME.name) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Rounded.Home,
                            contentDescription = null
                        )
                    },
                )
                NavigationBarItem(
                    colors = mNavigationBarItemColors(),
                    selected = false,
                    label = { MText(text = stringResource(R.string.search)) },
                    onClick = {
                        val intent = Intent(context, SearchActivity::class.java)
                        context.startActivity(intent)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = null
                        )
                    },
                )
                NavigationBarItem(
                    selected = currentRoute == MainScreens.FAVORITE.name,
                    colors = mNavigationBarItemColors(),
                    label = { MText(text = stringResource(R.string.favorite)) },
                    onClick = {
                        navController.navigate(MainScreens.FAVORITE.name) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Rounded.Favorite,
                            contentDescription = null
                        )
                    },
                )
                NavigationBarItem(
                    selected = currentRoute == MainScreens.MY_STORE.name,
                    colors = mNavigationBarItemColors(),
                    label = { MText(text = stringResource(R.string.my_store)) },
                    onClick = {
                        navController.navigate(MainScreens.MY_STORE.name) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Rounded.AccountCircle,
                            contentDescription = null
                        )
                    },
                )
            }
        }
    ) {
        Column (
            modifier = Modifier.padding(paddingValues = it)
        ) {
            MainNavigation(navController = navController)
        }
    }
}