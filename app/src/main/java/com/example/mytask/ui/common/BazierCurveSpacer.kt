package com.example.mytask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.example.mytask.ui.theme.Pink

/**
 * Created by Mohammed Taguldeen on 08/11/2023.
 */


@Composable
fun BezierCurveSpacer(modifier: Modifier,height: Int, curveFillingColor: Color) {

    val densityPx = Density(LocalContext.current).density

    val curveWidth = 150.dp
    val curveDepth = 45.dp

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp * densityPx
    val screenHeight = configuration.screenHeightDp * densityPx

    val curveDepthPx: Float = curveDepth.value * densityPx
    val curveWidthPx: Float = curveWidth.value * densityPx

    val curveStartPoint = (screenWidth - curveWidthPx) / 2
    val curveEndPoint = (screenWidth + curveWidthPx) / 2

    val curveSmoothnessOffsetPoint = 35 * densityPx
    val curveLowestPoint = curveStartPoint + curveWidthPx / 2
    Spacer(modifier = modifier
        .height(height.dp)
        .fillMaxWidth()
        .drawWithCache {
            onDrawBehind {
                /**
                 * drawing the returned Path above , filling the space left by the curve and
                 * setting color for the  it
                 * */
                drawPath(
                    path = getBezierCurvePath(
                        curveStartPoint = curveStartPoint,
                        curveSmoothnessOffsetPoint = curveSmoothnessOffsetPoint,
                        curveLowestPoint = curveLowestPoint,
                        curveDepthPx = curveDepthPx,
                        curveEndPoint = curveEndPoint,
                        screenWidth = screenWidth,
                        screenHighet = screenHeight
                    ), color = curveFillingColor, style = Fill
                )
            }
        })
}

@Preview
@Composable
fun BezierCurveSpacerPreview() {
    BezierCurveSpacer(modifier = Modifier,height = 50, curveFillingColor = Pink)
}