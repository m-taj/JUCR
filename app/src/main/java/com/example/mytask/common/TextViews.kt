package com.example.mytask.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

/**
 * Created by Mohammed Taguldeen on 04/11/2023.
 */


@Preview
@Composable
fun TextViewsPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        HeaderTextView(modifier = Modifier.fillMaxWidth(), text = "Header TextView")
        TitleTextView(modifier = Modifier.fillMaxWidth(), text = "Title TextView")
        NormalTextView(modifier = Modifier.fillMaxWidth(), text = "Normal TextView")
    }
}

@Composable
fun HeaderTextView(text: String, modifier: Modifier, color: Color = Color.Black) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium,
        color = color
    )
}

@Composable
fun TitleTextView(text: String, modifier: Modifier, color: Color= Color.Black) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.titleSmall,
        color = color
    )
}


@Composable
fun NormalTextView(text: String, modifier: Modifier, color: Color= Color.Black) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.labelSmall,
        color = color
    )
}