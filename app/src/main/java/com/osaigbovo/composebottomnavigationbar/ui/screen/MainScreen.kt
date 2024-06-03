package com.osaigbovo.composebottomnavigationbar.ui.screen

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.osaigbovo.composebottomnavigationbar.ui.composables.BottomNavigationBar
import com.osaigbovo.composebottomnavigationbar.ui.composables.BottomNavigationHost

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomAppBar { BottomNavigationBar(navController = navController) } }
    ) { innerPadding ->
        BottomNavigationHost(
            navController = navController,
            innerPadding = innerPadding
        )
    }
}
