package com.example.mytask.ui.common

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytask.R
import com.example.mytask.ui.theme.Pink

/*

@Composable
fun CollapsedHeaderView(scrollOffset: Float) {
    val imageSize by animateDpAsState(targetValue = maxOf(72.dp, 128.dp * scrollOffset), label = "")
    val linesCount = StrictMath.max(3f, scrollOffset * 6).toInt()
    Column(
        modifier = Modifier
            .background(Pink)
            .fillMaxWidth()
            .height(maxOf(100.dp, 170.dp * scrollOffset))
    ) {
        Row(
            modifier = Modifier
                .background(Pink)
                .fillMaxWidth()
                .height(maxOf(100.dp, 170.dp * scrollOffset))
        ) {
            Column {
                Text(text = "tesla")
                Text(
                    text = "tesla car is charging now", maxLines = linesCount
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.size(imageSize),
                painter = painterResource(id = R.drawable.tesla_car),
                contentDescription = null
            )
        }
        BezierCurveSpacer(height = 50, curveFillingColor = Pink)
    }
}

@Composable
fun ExpandedHeaderView(scrollOffset: Float) {

}


@Preview
@Composable
fun HeaderViewStatesPreview() {
    Column {
        CollapsedHeaderView()
        ExpandedHeaderView()
    }
}*/
