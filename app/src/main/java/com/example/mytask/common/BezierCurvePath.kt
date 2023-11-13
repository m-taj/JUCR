package com.example.mytask.common

import androidx.compose.ui.graphics.Path

/**
 * Created by Mohammed Taguldeen on 08/11/2023.
 *
 * function provides a path of a rectangle with a Curve at the middle of its top side
 * @param[curveStartPoint] represents curve start point on screen
 * @param[curveEndPoint] represents curve end point on screen
 * @param[curveSmoothnessOffsetPoint] represents curve smoothness point
 * @param[curveLowestPoint] represents lowest point on screen
 * @param[screenWidth] represents width of screen
 * @param[screenHeight] represents height of screen
 */
fun getBezierCurvePath(
    curveStartPoint: Float,
    curveSmoothnessOffsetPoint: Float,
    curveLowestPoint: Float,
    curveDepthPx: Float,
    curveEndPoint: Float,
    screenWidth: Float,
    screenHeight: Float,
): Path {
    return Path().apply {
        moveTo(screenWidth, 0f)
        lineTo(screenWidth, screenHeight)
        lineTo(0f, screenHeight)
        lineTo(0f, 0f)

        moveTo(0f, 0f)
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

        this.close()
    }
}