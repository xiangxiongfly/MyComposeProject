package com.example.mycomposeproject.ui.pages.simple.icon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.sharp.ShoppingCart
import androidx.compose.material.icons.twotone.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomposeproject.R

@Preview
@Composable
fun IconPage() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
            contentDescription = "矢量图资源"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Icon(
            bitmap = ImageBitmap.imageResource(id = R.drawable.img),
            contentDescription = "图片资源",
            modifier = Modifier.size(100.dp, 100.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "任意类型图资源"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = "Filled"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Icon(
            imageVector = Icons.Outlined.ShoppingCart,
            contentDescription = "Outlined"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Icon(
            imageVector = Icons.Rounded.ShoppingCart,
            contentDescription = "Rounded"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Icon(
            imageVector = Icons.Sharp.ShoppingCart,
            contentDescription = "Sharp"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Icon(
            imageVector = Icons.TwoTone.ShoppingCart,
            contentDescription = "TwoTone"
        )
    }
}