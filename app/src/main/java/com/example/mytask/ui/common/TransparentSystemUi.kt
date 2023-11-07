package com.example.mytask.ui.common

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.toArgb

/**
 * Created by Mohammed Taguldeen on 07/11/2023.
 */

@Composable
fun ChangeSystemBarsTheme(componentActivity: ComponentActivity, lightTheme: Boolean) {
    val barColor = MaterialTheme.colorScheme.background.toArgb()
    LaunchedEffect(lightTheme) {
        if (lightTheme) {
            componentActivity.enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.light(
                    barColor, barColor,
                ),
                navigationBarStyle = SystemBarStyle.light(
                    barColor, barColor,
                ),
            )
        } else {
            componentActivity.enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.dark(
                    barColor,
                ),
                navigationBarStyle = SystemBarStyle.dark(
                    barColor,
                ),
            )
        }
    }
}