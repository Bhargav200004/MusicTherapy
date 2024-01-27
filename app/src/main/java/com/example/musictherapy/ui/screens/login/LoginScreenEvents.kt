package com.example.musictherapy.ui.screens.login

sealed class LoginScreenEvents {

    data class OnEmailClick(val email : String) : LoginScreenEvents()

    data class OnPasswordClick(val password : String) : LoginScreenEvents()

}