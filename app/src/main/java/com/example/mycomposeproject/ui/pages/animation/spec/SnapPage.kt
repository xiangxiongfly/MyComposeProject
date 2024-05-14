package com.example.mycomposeproject.ui.pages.animation.spec

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
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
fun SnapPage() {
    val flag = remember { mutableStateOf(false) }
    val size by animateDpAsState(
        targetValue = if (flag.value) 300.dp else 100.dp,
        animationSpec = if (flag.value) tween(
            durationMillis = 5000,
            easing = LinearEasing
        ) else snap()
    )
    Box(
        Modifier
            .size(size)
            .background(Color.Blue)
            .clickable {
                flag.value = !flag.value
            }
    )
}