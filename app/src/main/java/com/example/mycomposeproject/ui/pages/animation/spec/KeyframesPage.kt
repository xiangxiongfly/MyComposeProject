package com.example.mycomposeproject.ui.pages.animation.spec

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun KeyframesPage() {
    val flag = remember { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (flag.value) 300.dp else 100.dp,
        animationSpec = keyframes {
            durationMillis = 5000
            100.dp at 1000 with LinearOutSlowInEasing // for 0-1000 ms
            150.dp at 2000 with FastOutLinearInEasing // for 1000-2000 ms
            200.dp at 3000 // 2000-3000 ms
        }
    )
    val color by animateColorAsState(
        targetValue = if (flag.value) Color.Red else Color.Blue,
        animationSpec = keyframes {
            durationMillis = 5000
            Color.Yellow at 1000 with LinearOutSlowInEasing // for 0-1000 ms
            Color.Gray at 2000 with FastOutLinearInEasing // for 1000-2000 ms
            Color.Cyan at 3000 // 2000-3000 ms
        }
    )
    Box(
        Modifier
            .size(size)
            .background(color)
            .clickable {
                flag.value = !flag.value
            }
    )
}