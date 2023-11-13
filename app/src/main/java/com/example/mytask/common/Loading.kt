package com.example.mytask.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytask.theme.Pink

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

@Preview
@Composable
fun loadingViewPreview() {
        DataLoadingView(
            innerPadding = PaddingValues(4.dp),
            modifier = Modifier.padding(16.dp),
        )
}