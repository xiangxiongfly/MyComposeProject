package com.example.mycomposeproject.ui.pages.simple.image

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomposeproject.R
import java.io.File

@Preview
@Composable
fun ImagePage() {

    Column {
        val context = LocalContext.current
        val path = "${context.cacheDir}${File.separator}bg_banner.png"
        val bitmap = BitmapFactory.decodeFile(path)
        Image(bitmap = bitmap.asImageBitmap(), contentDescription = "位图")
        Divider(modifier = Modifier.padding(vertical = 10.dp))
        Image(painter = painterResource(id = R.drawable.img), contentDescription = "图片")
        Divider(modifier = Modifier.padding(vertical = 10.dp))
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
            contentDescription = "矢量图"
        )
    }

}