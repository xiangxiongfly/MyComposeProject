package com.example.mycomposeproject.ui.pages.animation.high_level

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeproject.R
import com.example.mycomposeproject.ui.common.HorizontalDivider

@Composable
fun AnimatedContentPage() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyAnimatedContent1()
        HorizontalDivider()
        MyAnimateContentSize()
        HorizontalDivider2()
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MyAnimatedContent1() {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedContent(modifier = Modifier.wrapContentSize(), targetState = count) { targetCount ->
            Text("Count: ${targetCount}")
        }
        Button(onClick = { count++ }) {
            Text("add")
        }
    }
}

@Composable
fun MyAnimateContentSize() {
    val isExpanded = remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .size(360.dp)
            .padding(10.dp)
    ) {
        Text(
            text = "床前明月光，疑是地上霜，举头望明月，低头思故乡。床前明月光，疑是地上霜，举头望明月，低头思故乡。床前明月光，疑是地上霜，举头望明月，低头思故乡。",
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.animateContentSize(),
            maxLines = if (isExpanded.value) Int.MAX_VALUE else 2
        )
        Text(if (isExpanded.value) "收起" else "全文",
            color = Color.Blue,
            modifier = Modifier.clickable {
                isExpanded.value = !isExpanded.value
            }
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HorizontalDivider2() {
    var isExpanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedContent(
            targetState = isExpanded,
            transitionSpec = {
                fadeIn(animationSpec = tween(durationMillis = 150, delayMillis = 150)) with
                        fadeOut(animationSpec = tween(durationMillis = 150)) using
                        SizeTransform { initialSize, targetSize ->
                            if (targetState) {
                                keyframes {
                                    IntSize(targetSize.width, initialSize.height) at 150
                                    durationMillis = 300
                                }
                            } else {
                                keyframes {
                                    IntSize(initialSize.width, targetSize.height) at 150
                                    durationMillis = 300
                                }
                            }
                        }
            }
        ) { targetExpanded ->
            if (targetExpanded) {
                MyExpanded()
            } else {
                MyIcon()
            }
        }
        Button(onClick = { isExpanded = !isExpanded }) {
            Text("切换")
        }
    }
}

@Composable
fun MyExpanded() {
    Text(stringResource(id = R.string.poet2))
}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Default.Home, contentDescription = null)
}