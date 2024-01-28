package com.example.musictherapy.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(val route : String, val contentDescription:String, val icons : ImageVector){

    data object Home : NavigationItem(route = "home", contentDescription = "home icon",icons = Icons.Outlined.Home)
    data object Favorite : NavigationItem(route = "favorite", contentDescription = "favorite icon",icons = Icons.Outlined.FavoriteBorder)
    data object Location : NavigationItem(route = "location", contentDescription = "location icon",icons = Icons.Outlined.LocationOn)
    data object Music : NavigationItem(route = "music" ,contentDescription = "music icon",icons = Icons.Outlined.MusicNote)

}


