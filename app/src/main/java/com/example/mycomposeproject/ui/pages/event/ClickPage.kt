package com.example.mycomposeproject.ui.pages.event

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mycomposeproject.ui.common.HorizontalDivider

@Composable
fun ClickPage() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        MyClickable()
        HorizontalDivider()
        MyPointerInput()
        HorizontalDivider()
        MyCombinedClickable()
    }
}

@Composable
fun MyClickable() {
    val count = remember { mutableStateOf(0) }
    Text(
        "${count.value}",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(100.dp)
            .background(Color.Gray)
            .clickable {
                count.value += 2
            }
    )
}

@Composable
fun MyPointerInput() {
    val count = remember { mutableStateOf(0) }
    Text(
        "${count.value}",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(100.dp)
            .background(Color.Gray)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = { Log.e("TAG", "onPress") },
                    onLongPress = { Log.e("TAG", "onLongPress") },
                    onTap = {
                        Log.e("TAG", "onTap")
                        count.value += 2
                    },
                    onDoubleTap = { Log.e("TAG", "onDoubleTap") }
                )
            }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyCombinedClickable() {
    val count = remember { mutableStateOf(0) }
    Text(
        "${count.value}",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(100.dp)
            .background(Color.Gray)
            .combinedClickable(
                onLongClick = { Log.e("TAG", "onLongClick") },
                onDoubleClick = { Log.e("TAG", "onDoubleClick") },
                onClick = {
                    Log.e("TAG", "onTap")
                    count.value += 2
                },
            )
    )
}