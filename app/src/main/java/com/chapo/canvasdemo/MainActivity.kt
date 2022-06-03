package com.chapo.canvasdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import com.chapo.canvasdemo.chart.ChartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChartScreen()
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                DrawPath()
//            }
        }
    }
}

@Composable
fun DrawPath() {
    Canvas(modifier = Modifier.size(300.dp)) {

        val path = Path().apply {
            moveTo(0f, 0f)
            this.cubicTo(10f, 10f, 220.dp.toPx(), 220.dp.toPx(), 0f, 320f)
//            quadraticBezierTo(
//                50.dp.toPx(), 200.dp.toPx(),
//                300.dp.toPx(), 300.dp.toPx()
//            )
//            lineTo(270.dp.toPx(), 100.dp.toPx())
//            quadraticBezierTo(60.dp.toPx(), 80.dp.toPx(), 0f, 0f)
            close()
        }

        drawPath(
            path = path,
            Color.Blue,
        )
    }
}
