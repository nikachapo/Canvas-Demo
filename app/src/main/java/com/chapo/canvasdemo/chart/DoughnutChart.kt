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
fun DoughnutChart(
    chartModels: List<ChartModel>,
    chartSize: Dp,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFF0E9E9),
    strokeWidth: Float = 100f,
    cap: StrokeCap = StrokeCap.Round
) {
    Canvas(
        modifier = modifier
            .size(chartSize)
    ) {

        drawCircle(
            color = backgroundColor,
            style = Stroke(strokeWidth, cap = cap),
        )

        var startAngle = 0f
        chartModels.forEach { chartModel ->
            drawArc(
                chartModel.color,
                startAngle = startAngle,
                sweepAngle = (chartModel.percentage * 3.6f).also { startAngle += it },
                useCenter = false,
                style = Stroke(strokeWidth, cap = cap),
            )
        }

    }
}