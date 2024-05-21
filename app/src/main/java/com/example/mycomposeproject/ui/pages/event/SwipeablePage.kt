package com.example.mycomposeproject.ui.pages.event

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeablePage() {
    val size = 48.dp
    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) {
        size.toPx()
    }
    val anchors = mapOf(0F to 0, sizePx to 1)

    Box(
        modifier = Modifier
            .width(96.dp)
            .background(Color.Red)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { from, to -> FractionalThreshold(0.3F) },
                orientation = Orientation.Horizontal
            )
    ) {
        Box(
            modifier = Modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .size(size)
                .background(Color.Green)
        )
    }
}