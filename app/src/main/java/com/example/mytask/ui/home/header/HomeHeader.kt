package com.example.mytask.ui.home.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mytask.R
import com.example.mytask.ui.theme.Pink

/**
 * Created by Mohammed Taguldeen on 12/11/2023.
 */

@Composable
fun ExpandedHomeHeader(modifier: Modifier, imageResizeRange: () -> Dp) {
    Column(
        modifier = modifier
            .fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Good Morning, Billy",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodySmall,
            color = Color.White
        )
        Text(
            text = "Charging your car ..",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 32.dp),
            color = Color.White
        )
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 32.dp)
                .width(imageResizeRange()),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.tesla_art),
            contentDescription = null
        )
        Text(
            text = "Time to end of charge : 49 MIN",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color.White
        )
    }
}

@Composable
fun CollapsedHomeHeader(modifier: Modifier) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterVertically),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Testla Model S",
                style = MaterialTheme.typography.labelLarge,
                color = Color.White
            )
            Text(
                text = "Charging ϟ 58 %",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier
                .width(290.dp)
                .padding(start = 40.dp),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.tesla_art),
            contentDescription = null
        )
    }
}


@Preview
@Composable
fun HomeHeadersPreview() {
    Column(modifier = Modifier.background(Pink)) {
        ExpandedHomeHeader(modifier = Modifier) { 320.dp }
        Spacer(modifier = Modifier.weight(1f))
        CollapsedHomeHeader(modifier = Modifier)
    }
}