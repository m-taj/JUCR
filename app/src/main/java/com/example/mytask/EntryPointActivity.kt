package com.example.mytask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytask.presentation.home.viewmodel.HomeViewModel
import com.example.mytask.ui.home.HomeScreen
import com.example.mytask.ui.theme.MyTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class EntryPointActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskApplication()
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
private fun TaskApplication() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavigationKeys.Route.HOME_SCREEN) {
        composable(route = NavigationKeys.Route.HOME_SCREEN) {
            HomeScreenDestination()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
private fun HomeScreenDestination() {
    val viewModel: HomeViewModel = hiltViewModel()
    HomeScreen(viewModel

    )
}

object NavigationKeys {
    object Route {
        const val HOME_SCREEN = "HomeScreen"
    }
}