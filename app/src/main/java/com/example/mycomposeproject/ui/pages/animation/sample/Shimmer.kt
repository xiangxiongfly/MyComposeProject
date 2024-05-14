package com.example.mycomposeproject.ui.pages.animation.sample

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val barHeight = 10.dp
val spacerPadding = 3.dp
val roundedCornerShape = RoundedCornerShape(3.dp)
val shimmerColors = listOf(
    Color.LightGray.copy(alpha = 0.6F),
    Color.LightGray.copy(alpha = 0.2F),
    Color.LightGray.copy(alpha = 0.6F),
)

@Preview
@Composable
fun ShimmerItem() {
    val transition = rememberInfiniteTransition()
    val transitionAnim = transition.animateFloat(
        initialValue = 0F,
        targetValue = 1000F,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = transitionAnim.value, y = transitionAnim.value)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1F), verticalArrangement = Arrangement.Center) {
                repeat(5) {
                    Spacer(modifier = Modifier.padding(spacerPadding))
                    Spacer(
                        modifier = Modifier
                            .height(barHeight)
                            .clip(roundedCornerShape)
                            .fillMaxWidth()
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(spacerPadding))
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Spacer(
                modifier = Modifier
                    .size(100.dp)
                    .clip(roundedCornerShape)
                    .background(brush)
            )
        }
        repeat(3) {
            Spacer(modifier = Modifier.padding(spacerPadding))
            Spacer(
                modifier = Modifier
                    .height(barHeight)
                    .clip(roundedCornerShape)
                    .fillMaxWidth()
                    .background(brush)
            )
            Spacer(modifier = Modifier.padding(spacerPadding))
        }
    }
}

@Composable
fun ShimmerList(count: Int) {
    Column(modifier = Modifier.padding(5.dp)) {
        repeat(count) {
            ShimmerItem()
        }
    }
}

@Preview
@Composable
fun ShimmerListPreview() {
    ShimmerList(3)
}

