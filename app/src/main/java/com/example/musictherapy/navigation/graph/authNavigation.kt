package com.example.musictherapy.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.musictherapy.ui.screens.login.LoginScreen
import com.example.musictherapy.ui.screens.registration.RegistrationScreen

fun NavGraphBuilder.authNavigation(navHostController: NavHostController){

    navigation(
        route = NavigationGraph.AUTHENTICATION,
        startDestination = AuthScreen.SIGNUP.route
    ){
        composable(route = AuthScreen.SIGNUP.route){
            RegistrationScreen(navHostController)
        }
        composable(route = AuthScreen.LOGIN.route){
            LoginScreen(navHostController)
        }

    }

}

sealed class AuthScreen(val route : String){
    data object SPLASH : AuthScreen(route = "SPLASH")
    data object LOGIN : AuthScreen(route = "LOGIN")
    data object SIGNUP : AuthScreen(route = "SIGNUP")
    data object FORGET : AuthScreen(route = "FORGET")
}