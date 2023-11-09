package com.example.mytask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytask.presentation.home.viewmodel.HomeViewModel
import com.example.mytask.ui.common.ChangeSystemBarsTheme
import com.example.mytask.ui.home.HomeScreen
import com.example.mytask.ui.navigation.NavigationKeys
import com.example.mytask.ui.theme.TaskTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EntryPointActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskApplicationNavGraph()
                }
            }
        }
    }
}
@Composable
private fun TaskApplicationNavGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavigationKeys.Route.HOME_SCREEN) {
        composable(route = NavigationKeys.Route.HOME_SCREEN) {
            HomeScreenDestination()
        }
    }
}

@Composable
private fun HomeScreenDestination() {
    val viewModel: HomeViewModel = hiltViewModel()
    HomeScreen(viewModel)
}

