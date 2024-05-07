package com.example.mycomposeproject.ui.pages.layout

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.mycomposeproject.R

@Composable
fun ConstraintLayoutPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        MyGuideline()
        Divider(modifier = Modifier.padding(vertical = 10.dp))
        MyConstraintLayout1()
        Divider(modifier = Modifier.padding(vertical = 10.dp))
        MyConstraintLayout2()
        Divider(modifier = Modifier.padding(vertical = 10.dp))
        MyBarrier()
        Divider(modifier = Modifier.padding(vertical = 10.dp))
        MyChain()
    }
}

@Preview
@Composable
fun MyConstraintLayout1() {
    ConstraintLayout(
        modifier = Modifier
            .width(300.dp)
            .height(100.dp)
            .padding(10.dp)
    ) {
        val (portraitImageRef, usernameTextRef, descTextRef) = remember { createRefs() }
        Image(
            painterResource(id = R.drawable.img),
            null,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .constrainAs(portraitImageRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        )
        Text(
            "Jetpack Compose",
            fontSize = 16.sp,
            maxLines = 1,
            textAlign = TextAlign.Left,
            modifier = Modifier.constrainAs(usernameTextRef) {
                top.linkTo(portraitImageRef.top)
                start.linkTo(portraitImageRef.end, 10.dp)
            }
        )
        Text(
            "这是一堆描述信息",
            fontSize = 14.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Light,
            modifier = Modifier.constrainAs(descTextRef) {
                top.linkTo(usernameTextRef.bottom, 5.dp)
                start.linkTo(portraitImageRef.end, 10.dp)
            }
        )
    }
}

@Preview
@Composable
fun MyConstraintLayout2() {
    ConstraintLayout(
        modifier = Modifier
            .width(300.dp)
            .height(100.dp)
            .padding(10.dp)
    ) {
        val (portraitImageRef, usernameTextRef, descTextRef) = remember { createRefs() }
        Image(
            painterResource(id = R.drawable.img),
            null,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .constrainAs(portraitImageRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        )
        Text(
            "Jetpack Compose",
            fontSize = 16.sp,
            maxLines = 1,
            textAlign = TextAlign.Left,
            modifier = Modifier.constrainAs(usernameTextRef) {
                top.linkTo(portraitImageRef.top)
                start.linkTo(portraitImageRef.end, 10.dp)
            }
        )
        Text(
            "这是一堆描述信息这是一堆描述信息这是一堆描述信息这是一堆描述信息这是一堆描述信息这是一堆描述信息这是一堆描述信息这是一堆描述信息",
            fontSize = 14.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Light,
            maxLines = 1,
            modifier = Modifier.constrainAs(descTextRef) {
                top.linkTo(usernameTextRef.bottom, 5.dp)
                start.linkTo(portraitImageRef.end, 10.dp)
                width = Dimension.preferredWrapContent
            }
        )
    }
}

@Preview
@Composable
fun MyBarrier() {
    ConstraintLayout(
        modifier = Modifier
            .width(400.dp)
            .padding(10.dp)
    ) {
        val (usernameTextRef, passwordTextRef, usernameInputRef, passwordInputRef, dividerRef) = remember { createRefs() }
        val barrier = createEndBarrier(usernameTextRef, passwordTextRef)
        Text(
            "用户名",
            fontSize = 14.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.constrainAs(usernameTextRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        )
        Divider(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .constrainAs(dividerRef) {
                top.linkTo(usernameTextRef.bottom)
                bottom.linkTo(passwordTextRef.top)
            })
        Text(
            "密码",
            fontSize = 14.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.constrainAs(passwordTextRef) {
                top.linkTo(dividerRef.bottom)
                start.linkTo(parent.start)
            }
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.constrainAs(usernameInputRef) {
                start.linkTo(barrier, 10.dp)
                top.linkTo(usernameTextRef.top)
                bottom.linkTo(usernameTextRef.bottom)
                height = Dimension.fillToConstraints
            }
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.constrainAs(passwordInputRef) {
                start.linkTo(barrier, 10.dp)
                top.linkTo(passwordTextRef.top)
                bottom.linkTo(passwordTextRef.bottom)
                height = Dimension.fillToConstraints
            }
        )
    }
}

@Preview
@Composable
fun MyGuideline() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.LightGray)
    ) {
        val (portraitRef, bgRef, welcomeRef) = remember { createRefs() }
        val guideLine = createGuidelineFromTop(0.5F)
        Box(modifier = Modifier
            .background(Color.Blue)
            .constrainAs(bgRef) {
                top.linkTo(parent.top)
                bottom.linkTo(guideLine)
                height = Dimension.fillToConstraints
                width = Dimension.matchParent
            }
        )
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                .constrainAs(portraitRef) {
                    top.linkTo(guideLine)
                    bottom.linkTo(guideLine)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            "Jetpack Compose",
            color = Color.White,
            fontSize = 26.sp,
            modifier = Modifier.constrainAs(welcomeRef) {
                top.linkTo(portraitRef.bottom, 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Preview
@Composable
fun MyChain() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.LightGray)
    ) {
        val (oneRef, twoRef, threeRef, fourRef) = remember { createRefs() }
        createVerticalChain(oneRef, twoRef, threeRef, fourRef, chainStyle = ChainStyle.Spread)
        Text(
            text = "AAAAAAAAAAAAAAAAAA",
            color = Color.White,
            modifier = Modifier.constrainAs(oneRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(
            text = "AAAAAAAAAAAAAAAAAA",
            color = Color.White,
            modifier = Modifier.constrainAs(twoRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(
            text = "AAAAAAAAAAAAAAAAAA",
            color = Color.White,
            modifier = Modifier.constrainAs(threeRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(
            text = "AAAAAAAAAAAAAAAAAA",
            color = Color.White,
            modifier = Modifier.constrainAs(fourRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

    }

}



