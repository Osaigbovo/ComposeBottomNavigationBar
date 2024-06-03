package com.osaigbovo.composebottomnavigationbar.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.osaigbovo.composebottomnavigationbar.navigation.BottomNavigationItem.Home
import com.osaigbovo.composebottomnavigationbar.navigation.BottomNavigationItem.Profile
import com.osaigbovo.composebottomnavigationbar.navigation.BottomNavigationItem.Search
import com.osaigbovo.composebottomnavigationbar.ui.screen.HomeScreen
import com.osaigbovo.composebottomnavigationbar.ui.screen.ProfileScreen
import com.osaigbovo.composebottomnavigationbar.ui.screen.SearchScreen

@Composable
fun BottomNavigationHost(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(Home.route) { HomeScreen() }
        composable(Search.route) { SearchScreen() }
        composable(Profile.route) { ProfileScreen() }
    }
}
