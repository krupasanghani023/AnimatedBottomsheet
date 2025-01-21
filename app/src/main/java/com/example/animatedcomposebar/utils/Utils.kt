package com.example.animatedcomposebar.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

class Utils {
    sealed class NavigationItem(
        val title: String,
        val route: String,
        val icon: ImageVector,
        val selectedColor: Color,
        val screenColor: Color,
    ){
        data object HomeScreen : NavigationItem(
            title = "Home",
            route = "HomeScreen",
            icon = Icons.Default.Home,
            selectedColor = Color(0xFFFFFFFF),
            screenColor = Color(0xFF67F857)
        )
        data object SearchScreen : NavigationItem(
            title = "Search",
            route = "SearchScreen",
            icon = Icons.Default.Search,
            selectedColor = Color(0xFFFFFFFF),
            screenColor = Color(0xFF9459E7)
        )
        data object ProfileScreen : NavigationItem(
            title = "Profile",
            route = "ProfileScreen",
            icon = Icons.Default.AccountCircle,
            selectedColor = Color(0xFFFFFFFF),
            screenColor = Color(0xFF61F4D7)
        )
    }

}