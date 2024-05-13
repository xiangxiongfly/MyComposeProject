package com.example.mycomposeproject.ui.pages.animation.low_level

import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatablePage() {
    val selected = remember { mutableStateOf(false) }
    val color = remember { Animatable(Color.Red) }
    Column {
        Box(
            Modifier
                .size(360.dp)
                .background(color.value)
        )
        Button(onClick = { selected.value = !selected.value }) {
            Text("点击")
        }
    }

    LaunchedEffect(selected.value) {
        color.animateTo(if (selected.value) Color.Yellow else Color.Green)
    }
}