package com.example.mytask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Mohammed Taguldeen on 05/11/2023.
 */


@Composable
fun LoadingView(modifier: Modifier,innerPadding: PaddingValues) {
    Column(modifier= modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator()
        Text(
            text = "loading..", Modifier.padding(innerPadding)
        )
    }
}

@Preview
@Composable
fun loadingViewPreview() {
    LoadingView(modifier = Modifier.background(Color.White),PaddingValues(4.dp))
}