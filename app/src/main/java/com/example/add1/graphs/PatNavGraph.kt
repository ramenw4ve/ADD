package com.example.add1.graphs


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.add1.User_home_page
import com.example.add1.User_signin
import com.example.add1.User_signup


fun NavGraphBuilder.PatNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PAT,
        startDestination = Patscreen.SignUp.route
    ) {
//        composable(route = AuthScreen.SignUp.route) {
//            User_signup(navController = navController)
//        }
//        composable(route = AuthScreen.Login.route) {
//            ScreenContent(name = AuthScreen.Login.route) {}
//        }
        composable(route = Patscreen.SignUp.route) {
            User_signup(navController)
        }
        composable(route = Patscreen.SignIn.route) {
            User_signin(navController)
        }




    }
}

sealed class Patscreen(val route: String) {
    object Choose : Patscreen(route = "LOGINAS")
    object Home : Patscreen(route = "PHOME")
    object SignUp : Patscreen(route = "PSIGN_UP")
    object SignIn : Patscreen(route = "PSIGN_IN")
    object Forgot : Patscreen(route = "FORGOT")
}