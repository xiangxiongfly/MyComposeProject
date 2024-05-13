package com.example.mycomposeproject.ui.pages.animation.low_level

import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

@Composable
fun AnimationPage() {
    val anim = remember {
        TargetBasedAnimation(
            animationSpec = tween(20000),
            typeConverter = Int.VectorConverter,
            initialValue = 200,
            targetValue = 1000
        )
    }
    var playTime by remember { mutableStateOf(0L) }
    var count by remember { mutableStateOf(anim.initialValue) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("count: ${count}")
    }

    LaunchedEffect(anim) {
        val startTime = withFrameNanos { it }
        do {
            playTime = withFrameNanos { it } - startTime
            val animationValue = anim.getValueFromNanos(playTime)
            count = animationValue
        } while (anim.targetValue != animationValue)
    }
}