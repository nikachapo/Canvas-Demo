package com.chapo.canvasdemo.chart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PieChart(
    chartModels: List<ChartModel>,
    chartSize: Dp,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFF0E9E9),
    elevation: Dp = 15.dp,
) {

    Canvas(
        modifier = modifier
            .size(chartSize)
            .shadow(elevation = elevation, shape = CircleShape)
    ) {

        drawCircle(backgroundColor)

        var startAngle = 0f
        chartModels.forEach { chartModel ->
            drawArc(
                brush = Brush.verticalGradient(
                    listOf(
                        chartModel.color,
                        chartModel.color.copy(alpha = 0.3f)
                    )
                ),
                startAngle = startAngle,
                sweepAngle = (chartModel.percentage * 3.6f).also { startAngle += it },
                useCenter = true
            )
        }
        drawCircle(radius = 15f, color = Color.Black.copy(alpha = 0.7f))

    }
}
