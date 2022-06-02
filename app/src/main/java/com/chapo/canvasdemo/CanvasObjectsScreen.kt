package com.chapo.canvasdemo

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp

@Composable
fun CanvasObjects() {
    CreateCanvas()
}

@Composable
fun CreateCanvas() {

    val infiniteTransition = rememberInfiniteTransition()
    val rotationDegree by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000),
            repeatMode = RepeatMode.Restart
        )
    )
    Canvas(
        modifier = Modifier
            .background(Color.Gray)
            .padding(20.dp)
            .size(300.dp)
    ) {

        rotate(rotationDegree) {
            drawRect(
                Color.Cyan, Offset(
                    x = ((size.width) - 100f) / 2,
                    y = (size.height - 100f) / 2
                ), Size(100f, 100f)
            )
        }

//        drawArc(
//            color = Color.Cyan,
//            startAngle = 180f,
//            sweepAngle = 180f,
//            useCenter = false,
//            style = Stroke(width = 30f, cap = StrokeCap.Round)
//        )

//        drawCircle(
//            Brush.radialGradient(
//                listOf(Color.Cyan, Color.White, Color.Red),
//                center = center,
//            )
//        )
//
//        drawLine(
//            color = Color.Red,
//            start = center,
//            end = Offset(0f, 0f),
//            strokeWidth = 30f,
//            cap = StrokeCap.Round
//        )

//        drawLine(
//            start = Offset(x = 0f, y = size.height / 2),
//            end = Offset(x = size.width, y = size.height / 2),
//            color = Color.Blue,
//            strokeWidth = 36.0f,
//            pathEffect = PathEffect.dashPathEffect(
//                floatArrayOf(30f, 10f, 10f, 10f), phase = 0f
//            )
//        )

    }
}
