package com.example.animatedcomposebar

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.animatedcomposebar.customBottomBar.BubbleNavigationBar
import com.example.animatedcomposebar.customBottomBar.BubbleNavigationBarItem
import com.example.animatedcomposebar.ui.theme.AnimatedComposeBarTheme
import com.example.animatedcomposebar.utils.Utils

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedComposeBarTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val navigationItems = listOf(
                    Utils.NavigationItem.HomeScreen,
                    Utils.NavigationItem.SearchScreen,
                    Utils.NavigationItem.ProfileScreen
                )

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(WindowInsets.systemBars),
                    bottomBar = {
                        BubbleNavigationBar(
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp, bottom = 30.dp)
                                .clip(RoundedCornerShape(30.dp)),
                            navigationHeight = 56.dp,
                            containerColor = Color(0xFFFA4E4E),
                        ) {
                            navigationItems.forEach { navigationItem ->
                                BubbleNavigationBarItem(
                                    selected = currentRoute == navigationItem.route,
                                    onClick = {
                                        if (currentRoute != navigationItem.route) {
                                            navController.popBackStack()
                                            navController.navigate(navigationItem.route) {
                                                navController.graph.startDestinationRoute?.let { screen_route ->
                                                    popUpTo(screen_route) {
                                                        saveState = true
                                                    }
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },
                                    icon = navigationItem.icon,
                                    title = navigationItem.title,
                                    selectedColor = navigationItem.selectedColor,
                                    unSelectedBackgroundColor = Color(0x00000000),
                                    unSelectedIconColor = Color(0xFFFFFFFF),
                                    navigationPaddingVertical = 6.dp,
                                    navigationPaddingHorizontal = 15.dp
                                )
                            }
                        }
                    }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Utils.NavigationItem.HomeScreen.route
                    ) {
                        composable(Utils.NavigationItem.HomeScreen.route) {
                            HomeScreen()
                        }
                        composable(Utils.NavigationItem.SearchScreen.route) {
                            SearchScreen()
                        }
                        composable(Utils.NavigationItem.ProfileScreen.route) {
                            ProfileScreen()
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Utils.NavigationItem.HomeScreen.screenColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "HomeScreen")
    }
}

@Composable
fun SearchScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Utils.NavigationItem.SearchScreen.screenColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "SearchScreen")
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Utils.NavigationItem.ProfileScreen.screenColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "ProfileScreen")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimatedComposeBarTheme {
        Greeting("Android")
    }
}