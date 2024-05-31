package com.example.mycomposeproject.ui.pages.accompanist

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerPage() {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    var selectedIndex by remember { mutableStateOf(0) }
    val tabs = arrayOf(
        TabItem("首页", Icons.Default.Home) { MyPage(text = "首页", color = Color.Red) },
        TabItem("收藏", Icons.Default.Favorite) { MyPage(text = "收藏", color = Color.Green) },
        TabItem("设置", Icons.Default.Settings) { MyPage(text = "设置", color = Color.Blue) },
    )

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect {
            selectedIndex = it
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedIndex = selectedIndex,
                tabs = tabs,
                onClick = {
                    selectedIndex = it
                    coroutineScope.launch { pagerState.scrollToPage(selectedIndex) }
                }
            )
        }
    ) {
        HorizontalPager(
            count = tabs.size,
            modifier = Modifier.fillMaxSize(),
            state = pagerState
        ) { pageIndex ->
            tabs[pageIndex].content()
        }
    }
}

data class TabItem(
    val label: String,
    val icon: ImageVector,
    var content: @Composable () -> Unit
)

@Composable
fun BottomNavigationBar(selectedIndex: Int, tabs: Array<TabItem>, onClick: (Int) -> Unit) {
    NavigationBar {
        tabs.forEachIndexed { index, tabItem ->
            NavigationBarItem(
                label = { Text(tabItem.label) },
                icon = { Icon(tabItem.icon, null) },
                selected = selectedIndex == index,
                onClick = { onClick(index) }
            )
        }
    }
}

@Composable
fun MyPage(text: String, color: Color) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text)
    }
}