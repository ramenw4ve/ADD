package com.example.add1.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.add1.AddMed
import com.example.add1.AddMedicine
import com.example.add1.Addppage
import com.example.add1.BottomBarScreen
import com.example.add1.DocHomepage
import com.example.add1.DocProfile
import com.example.add1.User_home_page
import com.example.add1.User_profile_Screen
import com.example.add1.User_self_prescription
import com.example.add1.ViewCart

@Composable
fun DHomeNavGraph(navController: NavHostController, token: String) {
    NavHost(
        navController = navController,
        route = Graph.DHOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            DocHomepage(navController)
        }
//        composable(route = "${BottomBarScreen.Addm.route}/{patid}") { backStackEntry ->
//            val patid = backStackEntry.arguments?.getInt("patid") ?: 5
//            AddMedicine(patid = patid)
//        }
//        composable(
//            route = BottomBarScreen.Addm.route + "/{patientId}",
//            arguments = listOf(
//                navArgument("patientId") { type = NavType.IntType }
//            )
//        ) {backStackEntry ->
//            val patientId = backStackEntry.arguments?.getInt("patientId")
//            AddMedicine(patid = patientId!!) // Ensure patientId is not null
//        }
        composable(
            route = BottomBarScreen.SelfP.route
        ){
            Addppage(navController = navController)
        }
        composable(route = BottomBarScreen.Profile.route) {
            DocProfile(token)
        }
        addmNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.addmNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADDM,
        startDestination = addmscreen.addmedi.route
    ) {
        composable(route = addmscreen.addmedi.route + "/{patientId}",
            arguments = listOf(
                navArgument("patientId") { type = NavType.IntType }
            )){

            backStackEntry ->
            val patientId = backStackEntry.arguments?.getInt("patientId")
//            AddMedicine(patid = patientId!!) // Ensure patientId is not null
//            AddMed()

        }
        composable(route = addmscreen.addmedi.route + "/{patientId}",
            arguments = listOf(navArgument("patientId") {type  = NavType.StringType})
            )
        {

            AddMed(it.arguments?.getString("patientId"))
        }
    }
}

sealed class addmscreen(val route: String) {
    object addmedi : selfpscreen(route = "ADDMEDI")
    object viewmedi : selfpscreen(route = "VIEWMEDI")
}
