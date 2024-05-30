package com.example.mycomposeproject.ui.pages.event

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp

@Composable
fun DraggablePage() {
//    MyDraggable()
    MyDetectDragGestures()
}

@Composable
fun MyDraggable() {
    var offsetY by remember { mutableStateOf(0F) }
    Box(modifier = Modifier.fillMaxSize()) {
        Text("拖动",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .offset { IntOffset(0, offsetY.toInt()) }
                .draggable(
                    orientation = Orientation.Vertical,
                    state = rememberDraggableState(onDelta = { delta ->
                        offsetY += delta
                    })
                )
        )
    }
}

@Composable
fun MyDetectDragGestures() {
    val offsetX = remember { mutableStateOf(0F) }
    val offsetY = remember { mutableStateOf(0F) }
    Box(modifier = Modifier.fillMaxSize()) {
        Text("拖动",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .offset { IntOffset(offsetX.value.toInt(), offsetY.value.toInt()) }
                .pointerInput(Unit) {
                    // 监听任意方向的拖动手势：
                    detectDragGestures { change, dragAmount ->
                        offsetX.value += dragAmount.x
                        offsetY.value += dragAmount.y
                    }

                    // 监听水平拖动手势：
//                    detectHorizontalDragGestures { change, dragAmount ->
//                        offsetX.value += dragAmount
//                    }

                    // 监听垂直拖动手势：
//                    detectVerticalDragGestures { change, dragAmount ->
//                        offsetY.value += dragAmount
//                    }

                    // 监听长按后的拖动手势：
//                    detectDragGesturesAfterLongPress { change, dragAmount ->
//                        offsetX.value += dragAmount.x
//                        offsetY.value += dragAmount.y
//                    }
                }
        )
    }
}