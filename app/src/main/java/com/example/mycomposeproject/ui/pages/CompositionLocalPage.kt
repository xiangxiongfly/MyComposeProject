package com.example.mycomposeproject.ui.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mycomposeproject.ui.common.VerticalSpacer

var isStatic = false
val title: String
val localColor = if (isStatic) {
    title = "staticCompositionLocalOf"
    staticCompositionLocalOf { Color.Black }
} else {
    title = "compositionLocalOf"
    compositionLocalOf { Color.Black }
}
var log = "Jetpack Compose"

@SuppressLint("UnrememberedMutableState")
@Composable
fun CompositionLocalPage() {
    var color by remember { mutableStateOf(Color.Green) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(" ${title}")
        VerticalSpacer(10.dp)
        CompositionLocalProvider(localColor provides color) {
            MyBox("外层：${log}", 300.dp, Color.Red) {
                MyBox("中层：${log}", 200.dp, localColor.current) {
                    MyBox("内层：${log}", 100.dp, Color.Blue) {

                    }
                }
            }
        }
        Button(onClick = {
            color = Color.Yellow
            log = "recompose"
        }) {
            Text("修改")
        }
    }
}

@Composable
fun MyBox(tag: String, size: Dp, background: Color, content: @Composable () -> Unit = {}) {
    Column(
        modifier = Modifier
            .size(size)
            .background(background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = tag)
        content()
    }
}

