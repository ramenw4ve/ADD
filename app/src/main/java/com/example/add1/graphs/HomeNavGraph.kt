package com.example.add1.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.add1.BottomBarScreen
import com.example.add1.PatViewQR
import com.example.add1.Tablet
import com.example.add1.Talbet
import com.example.add1.User_home_page
import com.example.add1.User_payment
import com.example.add1.User_prescriptions
import com.example.add1.User_profile_Screen
import com.example.add1.User_self_prescription
import com.example.add1.ViewCart

@Composable
fun HomeNavGraph(navController: NavHostController, token: String) {
    NavHost(
        navController = navController,
        route = Graph.PHOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            User_home_page(token, navController = navController)
        }
        composable(route = BottomBarScreen.SelfP.route) {
            User_self_prescription(navController = navController)
        }
        composable(route = BottomBarScreen.Profile.route) {
            User_profile_Screen(token)
        }
        selfpNavGraph(navController = navController,token)
        activepNavGraph(navController = navController,token = token)
    }
}

fun NavGraphBuilder.selfpNavGraph(navController: NavHostController,token:String) {
    navigation(
        route = Graph.SELF,
        startDestination = selfpscreen.viewcart.route
    ) {

        composable(route = "${selfpscreen.viewcart.route}/{tablets}") { backStackEntry ->
            val tabletsString = backStackEntry.arguments?.getString("tablets") ?: ""
            val tabletList: List<Talbet> = tabletsString.split(",").map {
                val tabletValues = it.split(";")
                if (tabletValues.size == 5) {
                    Talbet(
                        tabletValues[0],
                        tabletValues[1],
                        mutableStateOf(tabletValues[2].toInt()),
                        tabletValues[3],
                        mutableStateOf(tabletValues[4].toInt())

                    )
                } else {
                    Talbet("deault", "", mutableStateOf(0),"", mutableStateOf(0))
                }
            }

            // Use the tabletList as needed in your ViewCart composable
            ViewCart(tabletList, toke = token)
        }




    }
}

fun NavGraphBuilder.activepNavGraph(navController: NavHostController,token: String) {
    navigation(
        route = Graph.ACTIVE,
        startDestination = activescreen.viewactive.route
    ) {
//        composable(route = selfpscreen.selfpre.route) {
//            User_self_prescription(navController = navController)
//        }
        composable(route = activescreen.viewactive.route) {
//            ScreenContent(name = selfpscreen.viewcart.route) {
//                navController.popBackStack(
//                    route = selfpscreen.selfpre.route,
//                    inclusive = false
//                )
//            }
            User_prescriptions(navController,token)
        }
        composable(route = activescreen.viewcart.route) {

           User_payment(navController,token)
        }
        composable(route = activescreen.viewqr.route) {

           PatViewQR(token)
        }
    }
}

    sealed class selfpscreen(val route: String) {
        object selfpre : selfpscreen(route = "SELFPRESCRIBE")
        object viewcart : selfpscreen(route = "VIEWCART")
    }

    sealed class activescreen(val route: String) {
        object viewactive : activescreen(route = "VIEWACTIVE")
        object viewcart : activescreen(route = "AVIEWCART")
        object viewqr : activescreen(route = "VIEWQR")
    }
