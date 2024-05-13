package com.example.mycomposeproject.ui.pages.animation.low_level

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mycomposeproject.R
import com.example.mycomposeproject.ui.common.HorizontalDivider

@Composable
fun TransitionPage() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        MyTransition1()
        HorizontalDivider()
        MyTransition2()
    }
}

sealed class BoxState(val color: Color, val size: Dp, val offset: Dp, val angle: Float) {
    operator fun not() = if (this is Small) Large else Small

    object Small : BoxState(Color.Blue, 60.dp, 20.dp, 0f)
    object Large : BoxState(Color.Red, 90.dp, 50.dp, 45f)
}

@Composable
fun MyTransition1() {
    var boxState: BoxState by remember { mutableStateOf(BoxState.Small) }
    val transition = updateTransition(targetState = boxState, label = "box_state")
    val color by transition.animateColor(label = "color") {
        it.color
    }
    val size by transition.animateDp(label = "size") {
        it.size
    }
    val offset by transition.animateDp(label = "offset") {
        it.offset
    }
    val angle by transition.animateFloat(label = "angle") {
        it.angle
    }

    Column {
        Box(
            Modifier
                .padding(top = 20.dp)
                .rotate(angle)
                .size(size)
                .offset(x = offset)
                .background(color)
        )
        Button(
            onClick = { boxState = !boxState }
        ) {
            Text("组合动画")
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
@Composable
fun MyTransition2() {
    var selected by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = selected, label = "selected state")
    val borderColor by transition.animateColor(label = "border color") { isSelected ->
        if (isSelected) Color.Red else Color.Blue
    }
    val elevation by transition.animateDp(label = "elevation") { isSelected ->
        if (isSelected) 10.dp else 2.dp
    }
    Surface(
        onClick = { selected = !selected },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, borderColor),
        elevation = elevation
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("hello")
            transition.AnimatedVisibility(
                visible = { targetSelected -> targetSelected },
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Text(stringResource(id = R.string.poet))
            }
            transition.AnimatedContent { targetState ->
                if (targetState) {
                    Text("选中")
                } else {
                    Icon(Icons.Default.Home, null)
                }
            }
        }
    }
}
