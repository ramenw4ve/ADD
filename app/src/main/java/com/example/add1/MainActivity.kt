package com.example.add1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.add1.graphs.RootNavigationGraph

//import com.example.add1.Character
//import io.ktor.client.headers.*


//val LocalToke = staticCompositionLocalOf<String?> { null }
class MainActivity : ComponentActivity() {

    private val ktorClient = KtorClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//User_home_page(toke = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWFkMjBjNjMwODJmMWE1MjFiYzRjOWEiLCJpYXQiOjE3MDU5OTEzMzQsImV4cCI6MTcwNTk5NDkzNH0.u4UtO6-cu_1bnZLCpmOlgnaQGy88t3XP3w_tQXOmzVY")
//                User_self_prescription(navController = rememberNavController())
//                RootNavigationGraph(navController = rememberNavController())
//User_payment(toke = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWFkMjBjNjMwODJmMWE1MjFiYzRjOWEiLCJpYXQiOjE3MDcxNDU4MjgsImV4cCI6MTcwNzE2MzgyOH0.PRIlRVgMWDsZfnzS4eLpMGNdtVMn03mU-Ixo3DxZreo")
//            AddMedicine()
//            User_prescriptions()
            User_self_prescription()
//                PatViewQR(toke = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWFkMjBjNjMwODJmMWE1MjFiYzRjOWEiLCJpYXQiOjE3MDcwOTYyMTIsImV4cCI6MTcwNzExNDIxMn0.OAcC6aNWLpOyPVnaGhGBtZYbMHlZv9zY8gAkMPtdJOw")
//            NavHost(navController = navController, startDestination = "psu") {
//                composable("psu") {
//                    User_signup(navController = navController)
//                }
//
//                composable(
//                    "pp" + "/{token}",
//                    arguments = listOf(
//                        navArgument("token") {type = NavType.StringType}
//                    )
//                    ) {backStackEntry ->
//                    User_profile_Screen(navController = navController,backStackEntry = backStackEntry)
//                }
//
//                composable("php"+"/{token}",
//                arguments = listOf(
//                    navArgument("token") {type = NavType.StringType}
//                )
//                ){backStackEntry ->
//                    User_home_page(navController = navController,backStackEntry = backStackEntry)
//                }
//            }
//            User_signin()
//            User_profile_Screen()
//            Doc_signup()
//                User_signup()
//            User_home_page()
//            DialogExamples()


            }
        }
    }




