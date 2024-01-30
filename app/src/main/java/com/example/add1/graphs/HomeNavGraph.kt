package com.example.add1.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.add1.BottomBarScreen
import com.example.add1.User_home_page
import com.example.add1.User_profile_Screen
import com.example.add1.User_self_prescription
import com.example.add1.ViewCart

@Composable
fun HomeNavGraph(navController: NavHostController,token:String) {
    NavHost(
        navController = navController,
        route = Graph.PHOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            User_home_page( token )
        }
        composable(route = BottomBarScreen.SelfP.route) {
            User_self_prescription(navController = navController)
        }
        composable(route = BottomBarScreen.Profile.route) {
            User_profile_Screen(token)
        }
        selfpNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.selfpNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.SELF,
        startDestination = selfpscreen.viewcart.route
    ) {
//        composable(route = selfpscreen.selfpre.route) {
//            User_self_prescription(navController = navController)
//        }
        composable(route = selfpscreen.viewcart.route) {
//            ScreenContent(name = selfpscreen.viewcart.route) {
//                navController.popBackStack(
//                    route = selfpscreen.selfpre.route,
//                    inclusive = false
//                )
//            }
            ViewCart()

        }
    }
}

sealed class selfpscreen(val route: String) {
    object selfpre : selfpscreen(route = "SELFPRESCRIBE")
    object viewcart : selfpscreen(route = "VIEWCART")
}
