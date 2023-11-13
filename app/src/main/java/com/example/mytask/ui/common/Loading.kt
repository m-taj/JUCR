package com.example.mytask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytask.ui.theme.Pink

/**
 * Created by Mohammed Taguldeen on 05/11/2023.
 */


@Composable
fun DataLoadingView(innerPadding: PaddingValues, modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(40.dp),
            strokeCap = StrokeCap.Round,
        )
        TitleTextView(
            text = "loading..", Modifier.padding(innerPadding)
        )
    }
}


@Composable
fun ChargingView(color: Color= Color.White, modifier: Modifier) {
    Box(
        modifier = modifier/*.padding(bottom = 32.dp)*/, contentAlignment = Alignment.TopCenter
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(45.dp), strokeCap = StrokeCap.Round, color = color
        )
        Column(modifier = Modifier.align(Alignment.TopCenter).padding(bottom = 8.dp)) {
            Text(
                text = "ϟ", modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.White
            )
            Text(
                text = "58%",
                style = MaterialTheme.typography.labelSmall,
                color = Color.White,
                modifier = Modifier.align(
                    Alignment.CenterHorizontally,
                )
            )
        }

    }
}

@Preview
@Composable
fun loadingViewPreview() {
    Column(modifier = Modifier.background(Pink)) {
        DataLoadingView(
            innerPadding = PaddingValues(4.dp),
            modifier = Modifier.padding(16.dp),
        )
        ChargingView(
            color = Color.Gray,
            modifier = Modifier.padding(16.dp),
        )
    }
}