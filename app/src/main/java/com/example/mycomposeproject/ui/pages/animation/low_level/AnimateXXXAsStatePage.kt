package com.example.mycomposeproject.ui.pages.animation.low_level

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AnimateXXXAsStatePage() {
    var isSmall by remember { mutableStateOf(true) }
    val size: Dp by animateDpAsState(if (isSmall) 40.dp else 100.dp) {
        Log.e("TAG", "尺寸发生变化：$it")
    }
    val color: Color by animateColorAsState(if (isSmall) Color.Red else Color.Blue) {
        Log.e("TAG", "颜色发生变化：$it")
    }
    Column(Modifier.padding(16.dp)) {
        Box(
            Modifier
                .size(size)
                .background(color)
        )
        Button(onClick = { isSmall = !isSmall }, modifier = Modifier.padding(vertical = 16.dp)) {
            Text("修改尺寸颜色")
        }
    }
}