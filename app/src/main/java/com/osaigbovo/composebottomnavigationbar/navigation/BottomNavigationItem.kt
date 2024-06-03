package com.osaigbovo.composebottomnavigationbar.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.osaigbovo.composebottomnavigationbar.R

sealed class BottomNavigationItem(
    val route: String,
    val navigationTitle: String,
    val navigationIcon: ImageVector,
    @StringRes val navigationLabelResourceId: Int
) {
    data object Home : BottomNavigationItem(
        route = "home",
        navigationTitle = NavigationTitle.HOME,
        navigationIcon = Default.Home,
        navigationLabelResourceId = R.string.home
    )

    data object Search : BottomNavigationItem(
        route = "search",
        navigationTitle = NavigationTitle.SEARCH,
        navigationIcon = Default.Search,
        navigationLabelResourceId = R.string.search
    )

    data object Profile : BottomNavigationItem(
        route = "profile",
        navigationTitle = NavigationTitle.PROFILE,
        navigationIcon = Default.Person,
        navigationLabelResourceId = R.string.profile
    )

    companion object {
        fun values() = listOf(Home, Search, Profile)
    }
}
