package com.example.add1.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.add1.BottomBarScreen
import com.example.add1.graphs.HomeNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(token:String,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        HomeNavGraph(navController = navController,token)
    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.SelfP,
        BottomBarScreen.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        NavigationBar {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon",
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),

                )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,

        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
