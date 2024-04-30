package com.example.mycomposeproject.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.mycomposeproject.R
import com.example.mycomposeproject.ui.pages.FourPage
import com.example.mycomposeproject.ui.pages.HomeNav
import com.example.mycomposeproject.ui.pages.ThreePage
import com.example.mycomposeproject.ui.pages.TwoPage
import com.example.mycomposeproject.ui.theme.MyComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val tabs = Tabs.values()
            var position by remember { mutableStateOf(Tabs.HOME) }
            var title by remember { mutableStateOf(position.title) }
            MyComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // 脚手架
                    Scaffold(
                        // 标题栏
                        topBar = {
                            TopAppBar(title = { Text(title) })
                        },
                        // 底部导航栏
                        bottomBar = {
                            BottomNavigation(backgroundColor = Color.White) {
                                tabs.forEach { tab ->
                                    BottomNavigationItem(
                                        selected = position == tab,
                                        onClick = { position = tab },
                                        icon = { Icon(painterResource(tab.iconRes), null) },
                                        label = { Text(tab.title) },
                                        alwaysShowLabel = false,
                                        selectedContentColor = Color.Red,
                                        unselectedContentColor = Color.Gray
                                    )
                                }
                            }
                        }
                    ) { paddingValues ->
                        // 内容
                        Box(modifier = Modifier.padding(paddingValues)) {
                            when (position) {
                                Tabs.HOME -> HomeNav()
                                Tabs.TWO -> TwoPage()
                                Tabs.THREE -> ThreePage()
                                Tabs.FOUR -> FourPage()
                            }
                            title = position.title
                        }
                    }
                }
            }
        }
    }
}

enum class Tabs(
    val title: String,
    @DrawableRes val iconRes: Int
) {
    HOME("home", R.mipmap.ic_home),
    TWO("two", R.mipmap.ic_two),
    THREE("three", R.mipmap.ic_three),
    FOUR("four", R.mipmap.ic_four);
}