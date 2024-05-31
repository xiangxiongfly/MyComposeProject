package com.example.mycomposeproject.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycomposeproject.ui.pages.accompanist.FlowPage
import com.example.mycomposeproject.ui.pages.accompanist.HorizontalPagerPage
import com.example.mycomposeproject.ui.pages.accompanist.SwipeRefreshPage
import com.example.mycomposeproject.ui.pages.accompanist.SystemUiControllerPage

@Composable
fun OthersNav() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "others_page") {
            composable("others_page") {
                OthersPage(navController)
            }
            composable("system_ui_controller_page") {
                SystemUiControllerPage()
            }
            composable("horizontal_pager_page") {
                HorizontalPagerPage()
            }
            composable("swipe_refresh_page") {
                SwipeRefreshPage()
            }
            composable("flow_page") {
                FlowPage()
            }
        }
    }
}

@Composable
fun OthersPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("system_ui_controller_page") }) {
            Text(text = "SystemUiController")
        }
        Button(onClick = { navController.navigate("horizontal_pager_page") }) {
            Text(text = "Pager")
        }
        Button(onClick = { navController.navigate("swipe_refresh_page") }) {
            Text(text = "SwipeRefresh")
        }
        Button(onClick = { navController.navigate("flow_page") }) {
            Text(text = "Flow")
        }
    }
}