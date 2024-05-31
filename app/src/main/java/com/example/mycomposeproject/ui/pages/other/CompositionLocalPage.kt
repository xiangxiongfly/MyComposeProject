package com.example.mycomposeproject.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mycomposeproject.ui.common.VerticalSpacer

@Composable
fun CompositionLocalPage() {
//    MyCompositionLocal1()
    MyCompositionLocal2()
}

@Preview
@Composable
fun MyCompositionLocal1() {
    val localString = compositionLocalOf { "Hello Compose" }
    Column {
        Text("${localString.current}", color = Color.Red)
        CompositionLocalProvider(localString provides "hello world") {
            Text("${localString.current}", color = Color.Green)
            CompositionLocalProvider(localString provides "hello android") {
                Text("${localString.current}", color = Color.Blue)
            }
        }
        Text("${localString.current}", color = Color.Red)
    }
}

var isStatic = true
val title: String
val localColor = if (isStatic) {
    title = "staticCompositionLocalOf"
    staticCompositionLocalOf { Color.White }
} else {
    title = "compositionLocalOf"
    compositionLocalOf { Color.White }
}
var message = "init"

@Preview
@Composable
fun MyCompositionLocal2() {
    var color by remember { mutableStateOf(Color.Green) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(" ${title}")
        VerticalSpacer(10.dp)
        MyBox("最外层：${message}", 400.dp, Color(0xFF123456)) {
            CompositionLocalProvider(localColor provides color) {
                MyBox("外层：${message}", 300.dp, Color.Red) {
                    MyBox("中层：${message}", 200.dp, localColor.current) {
                        MyBox("内层：${message}", 100.dp, Color.Magenta) {

                        }
                    }
                }
            }
        }
        Button(onClick = {
            color = Color.Yellow
            message = "recompose"
        }) {
            Text("修改")
        }
    }
}

@Composable
fun MyBox(tag: String, size: Dp, bgColor: Color, content: @Composable () -> Unit = {}) {
    Column(
        modifier = Modifier
            .size(size)
            .background(bgColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = tag)
        content()
    }
}

