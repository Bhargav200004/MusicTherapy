package com.example.musictherapy.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musictherapy.ui.screens.favoriteScreen.FavoriteScreen
import com.example.musictherapy.ui.screens.homeScreen.HomeScreen
import com.example.musictherapy.ui.screens.locationScreen.LocationScreen
import com.example.musictherapy.ui.screens.musicScreen.MusicScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation() {

    
    val navController = rememberNavController()
    
    val item = listOf(
        NavigationItem.Home,
        NavigationItem.Favorite,
        NavigationItem.Music,
        NavigationItem.Location
    )

    
    Scaffold (
        modifier = Modifier
            .fillMaxWidth(),
        bottomBar ={
            
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            
            //store the current route
            val currentRoute = navBackStackEntry?.destination?.route

            BottomHomeScreenBar(item , currentRoute , navController)

//            NavigationBar {
//            item.forEach {
//                NavigationBarItem(
//                    selected = currentRoute == it.route,
//                    onClick = {
//                        if (currentRoute != it.route){
//                             navController.graph.startDestinationRoute?.let {
//                                 navController.popBackStack(it,true)
//                             }
//
//                            navController.navigate(it.route){
//                                launchSingleTop = true
//                            }
//                        }
//                              },
//                    icon = {
//                        Icon(
//                            imageVector = it.icons,
//                            contentDescription = null,
//                            tint = if (currentRoute == it.route) Color.DarkGray else Color.LightGray
//                        )
//                    }
//                )
//            }
//            }
        }
    ){
        
        NavigationController(navController = navController)
        
    }

























//    val navController = rememberNavController()



//    Scaffold(
//        bottomBar = {
//            BottomHomeScreenBar()
//        }
//    ) {paddingValue->
//        NavHost(navController = navController, startDestination = "Home",modifier = Modifier.padding(paddingValues = paddingValue)){
//            composable(route = "Home"){
//                HomeScreen()
//            }
//            composable(route = "Music"){
//                MusicScreen()
//            }
//            composable(route = "Favorite"){
//                FavoriteScreen()
//            }
//            composable(route = "Location"){
//                LocationScreen()
//            }
//        }
//    }



}

sealed class NavigationItem(val route : String, val label:String, val icons : ImageVector){
    

    data object Home : NavigationItem(route = "home", label = "home",icons = Icons.Outlined.Home)
    data object Favorite : NavigationItem(route = "favorite", label = "favorite",icons = Icons.Outlined.FavoriteBorder)
    data object Location : NavigationItem(route = "location", label = "location",icons = Icons.Outlined.LocationOn)
    data object Music : NavigationItem(route = "music" ,label = "music",icons = Icons.Outlined.MusicNote)
    
}

@Composable
fun NavigationController(navController : NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route){
        composable(route = NavigationItem.Home.route){
            HomeScreen()
        }
        composable(route = NavigationItem.Favorite.route){
            FavoriteScreen()
        }
        composable(route = NavigationItem.Music.route){
            MusicScreen()
        }
        composable(route = NavigationItem.Location.route){
            LocationScreen()
        }
    }
}

@Composable
fun BottomHomeScreenBar(
    item: List<NavigationItem>,
    currentRoute: String?,
    navController: NavHostController
) {
    Box(modifier = Modifier.padding(horizontal = 20.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Box(
            modifier = Modifier
                .shadow(
                    ambientColor = Color.White,
                    spotColor = Color.White,
                    elevation = 8.dp,
                    shape = RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 40.dp
                    )
                )
                .clip(shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)),

        ) {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(height = 85.dp, width = 1000.dp),
                actions = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, bottom = 36.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                    ) {
                        item.forEach { navigationItem ->
                            IconButton(
                                onClick = {
                                    if (currentRoute != navigationItem.route) {
                                        navController.graph.startDestinationRoute?.let {
                                            navController.popBackStack(it, true)
                                        }

                                        navController.navigate(navigationItem.route) {
                                            launchSingleTop = true
                                        }
                                    }
                                },
                                icon = navigationItem.icons,
                                isIconSelected = currentRoute != navigationItem.route
                            )
                        }
                    }
                },
            )
        }
    }
}

@Composable
private fun IconButton(onClick : () -> Unit , icon : ImageVector , isIconSelected : Boolean) {
    IconButton(onClick = onClick ) {
        Icon(
            imageVector = icon,
            contentDescription = "Home",
            tint = if (!isIconSelected) MaterialTheme.colorScheme.primary else Color.LightGray
        )
    }
}


