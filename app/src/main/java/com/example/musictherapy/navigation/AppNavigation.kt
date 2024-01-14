package com.example.musictherapy.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musictherapy.ui.components.BottomNavigationScreenBar
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

            BottomNavigationScreenBar(
                item = item,
                currentRoute = currentRoute,
                navController = navController
            )

        }
    ){
        
        NavigationController(navController = navController)
        
    }

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


