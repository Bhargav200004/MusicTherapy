package com.example.musictherapy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musictherapy.navigation.graph.NavigationGraph
import com.example.musictherapy.navigation.graph.authNavigation


@Composable
fun RootNavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationGraph.AUTHENTICATION,
        route = NavigationGraph.ROOT_NAVIGATION_GRAPH,
    ){
        authNavigation(navHostController = navController)

        composable(route = NavigationGraph.MAIN_SCREEN_PAGE){
            MainScreenNavigation()
        }
    }

}






