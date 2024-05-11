package com.example.mycomposeproject.ui.pages.animation.high_level

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedContentPage() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyAnimatedContent()
        Divider()
        MyMyAnimatedContent2()
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MyAnimatedContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var count by remember { mutableStateOf(0) }
        AnimatedContent(modifier = Modifier.wrapContentSize(), targetState = count) { targetCount ->
            Text("Count: ${targetCount}")
        }
        Button(onClick = { count++ }) {
            Text("add")
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
@Composable
fun MyMyAnimatedContent2() {
    var isExpand by remember { mutableStateOf(false) }
    Surface(
        color = Color.Gray,
        onClick = { isExpand = !isExpand }
    ) {
        AnimatedContent(
            targetState = isExpand,
            transitionSpec = {
                fadeIn(animationSpec = tween(150, 150)) with
                        fadeOut(animationSpec = tween(150)) using
                        SizeTransform { initialSize, targetSize ->
                            if (targetState) {
                                // 展开：先水平方向再垂直方向
                                keyframes {
                                    durationMillis = 3000
                                    IntSize(targetSize.width, initialSize.height) at 1000
                                }
                            } else {
                                // 收起：垂直方向
                                keyframes {
                                    durationMillis = 3000
                                    IntSize(initialSize.width, targetSize.height) at 1000
                                }
                            }
                        }
            }
        ) { targetExpand ->
            if (targetExpand) {
                Expanded()
            } else {
                ContentIcon()
            }
        }
    }
}

@Composable
fun Expanded() {
    Text("这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容这是一些内容")
}

@Composable
fun ContentIcon() {
    Icon(Icons.Filled.Phone, null)
}