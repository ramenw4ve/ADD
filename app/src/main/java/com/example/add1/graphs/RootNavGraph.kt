package com.example.add1.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.add1.screens.home.DHomeScreen
import com.example.add1.screens.home.HomeScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        pauthNavGraph(navController = navController)
        composable(route = "${Graph.PHOME}/{token}") { backStackEntry ->
            val token = backStackEntry.arguments?.getString("token") ?: ""
            HomeScreen  (token = token)
        }
//        navController.navigate((Graph.PHOME)+"/$toke")
        composable(route = "${Graph.DHOME}/{dtoken}") { backStackEntry ->
            val dtoken = backStackEntry.arguments?.getString("dtoken") ?: ""
            DHomeScreen  (token = dtoken)
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val PHOME = "home_graph"
    const val DHOME = "dhome_graph"
    const val SELF = "self_graph"
    const val ADDM = "add_graph"
    const val DOC = "doc_graph"
    const val PAT = "pat_graph"
    const val ACTIVE = "active_graph"

}