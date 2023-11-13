package com.example.mytask.ui.common

import android.content.Context
import android.content.res.Configuration
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

/**
 * Created by Mohammed Taguldeen on 08/11/2023.
 */



fun bezierCurveCardProvider(context:()-> Context, localConfiguration:()-> Configuration):Path {

    val densityPx = Density(context()).density

    val curveWidth = 150.dp
    val curveDepth = 45.dp

    val configuration = localConfiguration()
    val screenWidth = configuration.screenWidthDp * densityPx
    val screenHeight = configuration.screenHeightDp * densityPx

    val curveDepthPx: Float = curveDepth.value * densityPx
    val curveWidthPx: Float = curveWidth.value * densityPx

    val curveStartPoint = (screenWidth - curveWidthPx) / 2
    val curveEndPoint = (screenWidth + curveWidthPx) / 2

    val curveSmoothnessOffsetPoint = 35 * densityPx
    val curveLowestPoint = curveStartPoint + curveWidthPx / 2

    return getBezierCurvePath(
        curveStartPoint = curveStartPoint,
        curveSmoothnessOffsetPoint = curveSmoothnessOffsetPoint,
        curveLowestPoint = curveLowestPoint,
        curveDepthPx = curveDepthPx,
        curveEndPoint = curveEndPoint,
        screenWidth = screenWidth,
        screenHeight = screenHeight
    )
}

//@Preview
//@Composable
//fun BezierCurveSpacerPreview() {
//    BezierCurveSpacer(modifier = Modifier,height = 150, curveFillingColor = Color.White)
//}