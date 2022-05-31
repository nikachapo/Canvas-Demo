package com.chapo.canvasdemo.chart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp

@Composable
fun StrokeChart(chartSize: Dp, chartModels: List<ChartModel>) {

    Canvas(
        modifier = Modifier
            .size(chartSize)
    ) {
        var startAngle = 0f

        drawArc(
            color = Color(0xFFF0E9E9),
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = false,
            style = Stroke(100f, cap = StrokeCap.Round, miter = 0f),
        )

        chartModels.forEach { chartModel ->
            drawArc(
                chartModel.color,
                startAngle = startAngle,
                sweepAngle = (chartModel.percentage * 360 / 100).also { startAngle += it },
                useCenter = false,
                style = Stroke(100f, cap = StrokeCap.Round, miter = 0f),
            )
        }

    }
}