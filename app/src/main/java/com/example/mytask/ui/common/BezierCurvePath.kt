package com.example.mytask.ui.common

import androidx.compose.ui.graphics.Path

/**
 * Created by Mohammed Taguldeen on 08/11/2023.
 */
fun getBezierCurvePath(
    curveStartPoint: Float,
    curveSmoothnessOffsetPoint: Float,
    curveLowestPoint: Float,
    curveDepthPx: Float,
    curveEndPoint: Float,
    screenWidth: Float,
    screenHighet:Float
): Path {
    return Path().apply {

        /**
         * drawing first horizontal line from screen start to curve start
         * at a zero value on Y axis
         * */
        lineTo(curveStartPoint, 0f)

        /**
         * drawing first half of the curve start
         * at a zero value on Y axis
         * */
        cubicTo(
            x1 = curveStartPoint + curveSmoothnessOffsetPoint,
            y1 = 0f,
            x2 = curveStartPoint + curveSmoothnessOffsetPoint,
            y2 = curveDepthPx,
            x3 = curveLowestPoint,
            y3 = curveDepthPx
        )

        /**
         * drawing second half of the curve start
         * at a zero value on Y axis
         * */
        cubicTo(
            x1 = curveEndPoint - curveSmoothnessOffsetPoint,
            y1 = curveDepthPx,
            x2 = curveEndPoint - curveSmoothnessOffsetPoint,
            y2 = 0f,
            x3 = curveEndPoint,
            y3 = 0f
        )
        /**
         * drawing second horizontal line from curve end screen end
         * at a zero value on Y axis
         * */
        lineTo(screenWidth, 0f)
    }
}