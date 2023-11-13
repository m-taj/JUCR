package com.example.mytask.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytask.ui.home.HomeScreenRoute

/**
 * Created by Mohammed Taguldeen on 13/11/2023.
 */
@Composable
fun TaskApplicationNavHost( navController: NavHostController = rememberNavController()) {
    NavHost(navController, startDestination = NavigationKeys.Route.HOME_SCREEN) {
        composable(route = NavigationKeys.Route.HOME_SCREEN) {
            HomeScreenRoute()
        }
    }
}