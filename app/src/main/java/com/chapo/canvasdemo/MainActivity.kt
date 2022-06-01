package com.chapo.canvasdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chapo.canvasdemo.chart.ChartModel
import com.chapo.canvasdemo.chart.DoughnutChart
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var cyanPercentage by remember { mutableStateOf(0f) }
            var greenPercentage by remember { mutableStateOf(0f) }
            var yellowPercentage by remember { mutableStateOf(0f) }

            LaunchedEffect(key1 = Unit) {
                delay(500)
                cyanPercentage = 30f
                greenPercentage = 20f
                yellowPercentage = 40f
            }

            val cyanAnimatedPercentageState = animateFloatAsState(
                targetValue = cyanPercentage,
                animationSpec = tween(1000)
            )

            val greenAnimatedPercentageState = animateFloatAsState(
                targetValue = greenPercentage,
                animationSpec = tween(1000)
            )

            val yellowAnimatedPercentageState = animateFloatAsState(
                targetValue = yellowPercentage,
                animationSpec = tween(1000)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DoughnutChart(
                    chartModels = listOf(
                        ChartModel(cyanAnimatedPercentageState.value, Cyan),
                        ChartModel(greenAnimatedPercentageState.value, Green),
                        ChartModel(yellowAnimatedPercentageState.value, Yellow),
                    ),
                    chartSize = 200.dp,
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 64.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ChartValueTextField(color = Cyan, value = cyanPercentage) { value ->
                        cyanPercentage = value
                    }
                    ChartValueTextField(color = Green, value = greenPercentage) { value ->
                        greenPercentage = value
                    }
                    ChartValueTextField(Yellow, yellowPercentage) { value ->
                        yellowPercentage = value
                    }
                }

            }

        }
    }

    @Composable
    private fun ChartValueTextField(color: Color, value: Float, onValueChange: (Float) -> Unit) {
        BasicTextField(
            modifier = Modifier
                .width(88.dp)
                .height(48.dp)
                .wrapContentSize(Alignment.Center)
                .clip(RoundedCornerShape(16.dp))
                .background(color)
                .padding(16.dp),
            value = if (value == 0f) "" else value.toInt()
                .toString(),
            onValueChange = {
                if (it.isNotEmpty()) onValueChange(it.toFloat()) else onValueChange(0f)
            },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
        )
    }
}
