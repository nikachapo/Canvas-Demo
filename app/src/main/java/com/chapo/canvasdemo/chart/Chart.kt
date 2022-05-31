package com.chapo.canvasdemo.chart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Chart(chartSize: Dp, chartModels: List<ChartModel>) {

    Canvas(
        modifier = Modifier
            .size(chartSize)
            .shadow(15.dp, RoundedCornerShape(100))
    ) {
        var startAngle = 0f

        drawCircle(Color(0xFFF0E9E9))

        chartModels.forEach { chartModel ->
            drawArc(
                brush = Brush.verticalGradient(
                    listOf(
                        chartModel.color,
                        chartModel.color.copy(alpha = 0.3f)
                    )
                ),
                startAngle = startAngle,
                sweepAngle = (chartModel.percentage * 360 / 100).also { startAngle += it },
                useCenter = true
            )
        }
        drawCircle(radius = 15f, color = Color.Black.copy(alpha = 0.7f))

    }
}

data class ChartModel(val percentage: Float, val color: Color)
