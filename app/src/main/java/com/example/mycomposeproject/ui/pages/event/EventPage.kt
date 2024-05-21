package com.example.mycomposeproject.ui.pages.event

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun EventPage(
    onClickPage: () -> Unit,
    onClickDraggablePage: () -> Unit,
    onClickSwipeablePage: () -> Unit,
    onClickTransformablePage: () -> Unit,
    onClickScrollPage: () -> Unit,
    onClickNestedScrollPage: () -> Unit,
) {
    Column {
        Button(onClick = onClickPage) {
            Text("点击事件")
        }
        Button(onClick = onClickDraggablePage) {
            Text("拖动事件")
        }
        Button(onClick = onClickSwipeablePage) {
            Text("滑动事件")
        }
        Button(onClick = onClickTransformablePage) {
            Text("多点触控")
        }
        Button(onClick = onClickScrollPage) {
            Text("滚动事件")
        }
        Button(onClick = onClickNestedScrollPage) {
            Text("嵌套滚动事件")
        }
    }
}
