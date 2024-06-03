package com.osaigbovo.composebottomnavigationbar.ui.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.osaigbovo.composebottomnavigationbar.navigation.BottomNavigationItem

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        BottomNavigationItem.values().forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any {
                    it.route == bottomNavigationItem.route
                } == true,
                icon = {
                    Icon(
                        bottomNavigationItem.navigationIcon,
                        contentDescription = bottomNavigationItem.navigationTitle
                    )
                },
                label = {
                    Text(stringResource(bottomNavigationItem.navigationLabelResourceId))
                },
                onClick = {
                    // selectedItemIndex = index
                    navController.navigate(bottomNavigationItem.route) {
                        // Pop up to the start destination of the graph to avoid building up a large stack of destinations on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        // Avoid multiple copies of the same destination when reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}
