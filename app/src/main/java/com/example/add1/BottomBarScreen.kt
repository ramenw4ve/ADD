package com.example.add1

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "HOME",
        title = "HOME",
        icon = Icons.Default.Home
    )

    object Profile : BottomBarScreen(
        route = "PROFILE",
        title = "PROFILE",
        icon = Icons.Default.Person
    )

    object SelfP : BottomBarScreen(
        route = "SELFP",
        title = "SELFP",
        icon = Icons.Default.Create
    )

//    object Addm : BottomBarScreen(
//        route = "ADDM",
//        title = "ADDM",
//        icon = Icons.Default.Create
//    )
}
