package com.example.mycomposeproject.ui.pages.animation.sample

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mycomposeproject.ui.theme.Purple500

sealed class ButtonState(
    val bgColor: Color,
    val textColor: Color,
    val roundedCorner: Int,
    val buttonWidth: Dp
) {
    // 未收藏
    object NotFavorite : ButtonState(Purple500, Color.White, 50, 60.dp)

    // 已收藏
    object Favorite : ButtonState(Color.White, Purple500, 6, 300.dp)
}

const val animateDuration = 2000

@Composable
fun AnimateFavButton() {
    var buttonState: ButtonState by remember { mutableStateOf(ButtonState.NotFavorite) }
    val transition = updateTransition(targetState = buttonState, label = "fav button state")
    val bgColor by transition.animateColor(
        transitionSpec = { tween(durationMillis = animateDuration) },
        label = "bgColor"
    ) {
        it.bgColor
    }
    val textColor by transition.animateColor(
        transitionSpec = { tween(durationMillis = animateDuration) },
        label = "textColor"
    ) {
        it.textColor
    }
    val roundedCorner by transition.animateInt(
        transitionSpec = { tween(durationMillis = animateDuration) },
        label = "roundedCorner"
    ) {
        it.roundedCorner
    }
    val buttonWidth by transition.animateDp(
        transitionSpec = { tween(durationMillis = animateDuration) },
        label = "buttonWidth"
    ) {
        it.buttonWidth
    }
    FavButton(buttonState = buttonState, bgColor, textColor, roundedCorner, buttonWidth) {
        buttonState =
            if (buttonState == ButtonState.NotFavorite) {
                ButtonState.Favorite
            } else ButtonState.NotFavorite
    }
}

@Composable
fun FavButton(
    buttonState: ButtonState,
    bgColor: Color = buttonState.bgColor,
    textColor: Color = buttonState.textColor,
    roundedCorner: Int = buttonState.roundedCorner,
    buttonWidth: Dp = buttonState.buttonWidth,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(width = buttonWidth, height = 60.dp),
        shape = RoundedCornerShape(roundedCorner.coerceIn(0..100)),
        colors = ButtonDefaults.buttonColors(bgColor),
        border = BorderStroke(1.dp, Purple500)
    ) {
        if (buttonState == ButtonState.NotFavorite) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = textColor
            )
        } else if (buttonState == ButtonState.Favorite) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = textColor,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "已收藏",
                    softWrap = false,
                    color = textColor
                )
            }
        }
    }
}

@Preview
@Composable
fun FavButtonPreview() {
    FavButton(ButtonState.NotFavorite)
}

@Preview
@Composable
fun FavButtonPreview2() {
    FavButton(ButtonState.Favorite)
}