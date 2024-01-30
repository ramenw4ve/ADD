package com.example.add1.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.add1.Login_as
import com.example.add1.User_signup
import com.example.add1.screens.ScreenContent

fun NavGraphBuilder.pauthNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Choose.route
    ) {
        composable(route = AuthScreen.Choose.route) {
            Login_as(navController = navController)
        }

        DocNavGraph(navController)
        PatNavGraph(navController)

    }
}

sealed class AuthScreen(val route: String) {
    object Choose : AuthScreen(route = "LOGINAS")
    object Login : AuthScreen(route = "LOGIN")

}