package com.example.mycomposeproject.ui.pages.animation.high_level

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedVisibilityPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MyAnimatedVisibility1()
        Divider()
        MyAnimatedVisibility2()
    }
}

@Composable
fun MyAnimatedVisibility1() {
    val visible = remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .size(360.dp)
            .padding(10.dp)
    ) {
        Button(onClick = { visible.value = !visible.value }) {
            Text("可见性动画")
        }
        AnimatedVisibility(visible = visible.value) {
            Text(text = "床前明月光，疑是地上霜，举头望明月，低头思故乡", modifier = Modifier.size(150.dp))
        }
    }
}

@Composable
fun MyAnimatedVisibility2() {
    val visible = remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .size(360.dp)
            .padding(10.dp)
    ) {
        Button(onClick = { visible.value = !visible.value }) {
            Text("可见性动画")
        }
        AnimatedVisibility(visible = visible.value,
            enter = slideIn { IntOffset(600, 600) } + expandIn(),
            exit = slideOut { IntOffset(200, 200) } + shrinkOut()) {
            Text(
                text = "床前明月光，疑是地上霜，举头望明月，低头思故乡", modifier = Modifier.size(150.dp)
            )
        }
    }
}
