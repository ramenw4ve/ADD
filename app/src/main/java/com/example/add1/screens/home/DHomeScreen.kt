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
import com.example.add1.graphs.DHomeNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DHomeScreen(token:String,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        DHomeNavGraph(navController = navController,token)
    }
}
