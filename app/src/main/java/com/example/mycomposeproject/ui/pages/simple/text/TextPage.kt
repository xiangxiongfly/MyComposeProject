package com.example.mycomposeproject.ui.pages.simple.text

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeproject.R

@Preview
@Composable
fun TextPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Text(
            "hello compose", // 指定字符串
            color = Color.Red,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
        Text(
            stringResource(id = R.string.app_text), // 指定字符串资源
            color = Color.Blue,
            fontFamily = FontFamily.Cursive
        )
        Text("下划线", textDecoration = TextDecoration.Underline)
        Text("贯穿线", textDecoration = TextDecoration.LineThrough)
        Text(
            "猫和老鼠",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(250.dp) // 宽
                .border(width = 1.dp, color = Color.Gray) // 边框
        )
        Text(
            "床前明月光，疑似地上霜，举头望明月，低头思故乡",
            lineHeight = 35.sp, // 行高
            modifier = Modifier
                .width(250.dp)
                .drawBehind {
                    drawRoundRect(
                        color = Color.Red, style = Stroke(
                            width = 1.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                        )
                    )
                },
        )
        Text(
            "床前明月光，疑似地上霜，举头望明月，低头思故乡",
            modifier = Modifier.width(250.dp),
            maxLines = 1, // 最大行数
            overflow = TextOverflow.Ellipsis // 溢出处理
        )
        Divider()
        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
                append("H")
            }
            append("ello")
            withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)) {
                append("W")
            }
            append("orld")
        })
        Text(buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("Hello World")
                    append("\n")
                }
                withStyle(style = SpanStyle(color = Color.Red)) {
                    append("Hello Android")
                    append("\n")
                }
                append("Hello Compose")
            }
        })
        Divider()
        SelectionContainer(modifier = Modifier.fillMaxSize()) {
            Column {
                Text("床前明月光")
                Text("疑是地下霜")
                DisableSelection {
                    Text("hello")
                    Text("world")
                }
                Text("举头望明月")
                Text("低头思故乡")
            }
        }
        Divider()
        ClickableText(text = AnnotatedString("hello world"),
            onClick = { offset ->
                Log.e("TAG", "offset: ${offset}")
            }
        )
        Divider()
        val annotatedString = buildAnnotatedString {
            append("点击")
            pushStringAnnotation(tag = "URL", annotation = "https://www.baidu.com/")
            withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)) {
                append("Url")
            }
            pop()
        }
        ClickableText(
            text = annotatedString,
            style = TextStyle(fontSize = 30.sp),
            onClick = { offset ->
                annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
                    .firstOrNull()?.let { annotation -> Log.e("TAG", annotation.item) }
            })
    }
}
