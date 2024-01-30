package com.example.add1.graphs


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.add1.Doc_signup

//import com.example.add1.DocHome
//import com.example.add1.DocSignUp


fun NavGraphBuilder.DocNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DOC,
        startDestination = DocScreen.SignUp.route
    ) {
//        composable(route = AuthScreen.SignUp.route) {
//            User_signup(navController = navController)
//        }
//        composable(route = AuthScreen.Login.route) {
//            ScreenContent(name = AuthScreen.Login.route) {}
//        }
        composable(route = DocScreen.SignUp.route) {
            Doc_signup(navController)
        }
//        composable(route = DocScreen.Home.route) {
////            DocHome()
//        }


    }
}

sealed class DocScreen(val route: String) {
    object Choose : DocScreen(route = "LOGINAS")
    object Home : DocScreen(route = "DHOME")
    object SignUp : DocScreen(route = "DSIGN_UP")
    object Forgot : DocScreen(route = "FORGOT")
}