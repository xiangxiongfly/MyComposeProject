package com.example.mycomposeproject.ui.pages.animation.spec

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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
fun SpringPage() {
    val selected = remember { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (selected.value) 300.dp else 100.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )
    val color by animateColorAsState(
        targetValue = if (selected.value) Color.Red else Color.Blue,
        animationSpec = spring()
    )
    Box(
        Modifier
            .size(size)
            .background(color)
            .clickable {
                selected.value = !selected.value
            }
    )
}