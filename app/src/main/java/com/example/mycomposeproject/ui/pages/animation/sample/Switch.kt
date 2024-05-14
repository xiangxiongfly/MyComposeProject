package com.example.mycomposeproject.ui.pages.animation.sample

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeproject.R

sealed class SwitchState(var textAlpha: Float, var selectBarPadding: Dp) {
    object Open : SwitchState(0F, 0.dp)
    object Close : SwitchState(1F, 40.dp)
}

@Composable
fun SwitchImage() {
    var selectedState: SwitchState by remember { mutableStateOf(SwitchState.Close) }
    val transition = updateTransition(targetState = selectedState, label = "switch")
    val textAlpha by transition.animateFloat(transitionSpec = { tween(1000) }, label = "") {
        it.textAlpha
    }
    val selectBarPadding by transition.animateDp(transitionSpec = { tween(1000) }, label = "") {
        it.selectBarPadding
    }

    SwitchLabel(selectedState, textAlpha, selectBarPadding) {
        selectedState =
            if (selectedState == SwitchState.Open) SwitchState.Close else SwitchState.Open
    }
}

@Composable
fun SwitchLabel(
    selectedState: SwitchState,
    textAlpha: Float = selectedState.textAlpha,
    selectBarPadding: Dp = selectedState.selectBarPadding,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
    ) {
        Image(
            painterResource(id = R.drawable.img),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Text(
            "点击",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .alpha(textAlpha)
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(40.dp)
                .padding(top = selectBarPadding)
                .background(Color(0xFF5FB878))
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .alpha(1 - textAlpha)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    "已选择",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W900,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun SwitchImagePreview() {
    SwitchLabel(SwitchState.Open)
}

@Preview
@Composable
fun SwitchImagePreview2() {
    SwitchLabel(SwitchState.Close)
}