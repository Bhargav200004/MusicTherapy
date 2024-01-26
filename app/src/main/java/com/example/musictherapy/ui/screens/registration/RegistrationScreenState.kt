package com.example.musictherapy.ui.screens.registration

data class RegistrationScreenState(
    val fullName : String = "",
    val email : String = "",
    val password : String = "",
    val confirmPassword : String = "",
    val isSelected : Boolean = true
)
