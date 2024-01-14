package com.example.musictherapy.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavScreen(val route : String , image : ImageVector , label : String) {

    data object Home : NavScreen("Home",Icons.Outlined.Home,"home icon")
    data object Music : NavScreen("Home",Icons.Outlined.Home,"home icon")
    data object Favorite : NavScreen("Home",Icons.Outlined.Home,"home icon")
    data object Location : NavScreen("Home",Icons.Outlined.Home,"home icon")

}

val item = listOf(
    NavScreen.Home,
    NavScreen.Music,
    NavScreen.Favorite,
    NavScreen.Location,
)