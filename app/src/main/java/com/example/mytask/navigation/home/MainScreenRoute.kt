package com.example.mytask.navigation.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mytask.home.HomeScreen
import com.example.mytask.home.presentation.viewmodel.HomeViewModel

/**
 * Created by Mohammed Taguldeen on 13/11/2023.
 * no navigation from this screen
 */

@Composable
fun HomeScreenRoute() {
    val viewModel: HomeViewModel = hiltViewModel()
    HomeScreen(viewModel)
}
