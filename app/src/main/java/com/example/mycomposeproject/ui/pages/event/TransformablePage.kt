package com.example.mycomposeproject.ui.pages.event

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun TransformablePage() {
//    MyTransformable()
    MyDetectTransformGestures()
}

@Composable
fun MyTransformable() {
    val boxSize = 100.dp
    var offset by remember { mutableStateOf(Offset.Zero) }
    var rotationAngle by remember { mutableStateOf(1F) }
    var scale by remember { mutableStateOf(1F) }
    val transformableState =
        rememberTransformableState { zoomChange: Float, panChange: Offset, rotationChange: Float ->
            scale *= zoomChange
            offset += panChange
            rotationAngle += rotationChange
        }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .size(boxSize)
                .rotate(rotationAngle)
                .offset {
                    IntOffset(offset.x.roundToInt(), offset.y.roundToInt())
                }
                .scale(scale)
                .background(Color.Green)
                .transformable(
                    state = transformableState,
                    lockRotationOnZoomPan = true
                )
        )
    }
}

@Composable
fun MyDetectTransformGestures() {
    val boxSize = 100.dp
    var offset by remember { mutableStateOf(Offset.Zero) }
    var rotateAngle by remember { mutableStateOf(0F) }
    var scale by remember { mutableStateOf(1F) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .size(boxSize)
                .rotate(rotateAngle)
                .scale(scale)
                .offset {
                    IntOffset(offset.x.roundToInt(), offset.y.roundToInt())
                }
                .background(Color.Green)
                .pointerInput(Unit) {
                    detectTransformGestures(
                        panZoomLock = true,
                        onGesture = { centroid: Offset, pan: Offset, zoom: Float, rotation: Float ->
                            offset += pan
                            scale *= zoom
                            rotateAngle += rotation
                        }
                    )
                }
        )
    }
}