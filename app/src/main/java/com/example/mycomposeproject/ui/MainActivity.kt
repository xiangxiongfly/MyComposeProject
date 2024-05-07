package com.example.mycomposeproject.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
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
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            val tabs = Tabs.values()
            var selectedPosition by remember { mutableStateOf(Tabs.HOME) }
            var title by remember { mutableStateOf(selectedPosition.title) }
            MyComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // 脚手架
                    Scaffold(
                        scaffoldState = scaffoldState,
                        // 标题栏
                        topBar = {
                            TopAppBar(
                                title = { Text(title) },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch { scaffoldState.drawerState.open() }
                                    }) {
                                        Icon(Icons.Filled.Home, null)
                                    }
                                }
                            )
                        },
                        // 侧边栏
                        drawerContent = {
                            Text("hello world")
                        },
                        // 底部导航栏
                        bottomBar = {
                            BottomNavigation(backgroundColor = Color.White) {
                                tabs.forEach { tab ->
                                    BottomNavigationItem(
                                        selected = selectedPosition == tab,
                                        onClick = { selectedPosition = tab },
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
                            when (selectedPosition) {
                                Tabs.HOME -> HomeNav()
                                Tabs.TWO -> TwoPage()
                                Tabs.THREE -> ThreePage()
                                Tabs.FOUR -> FourPage()
                            }
                            title = selectedPosition.title
                        }
                    }
                    // 拦截系统返回键
                    BackHandler(enabled = scaffoldState.drawerState.isOpen) {
                        scope.launch {
                            scaffoldState.drawerState.close()
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