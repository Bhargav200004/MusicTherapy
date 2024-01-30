package com.example.musictherapy.ui.screens.registration

sealed class RegistrationScreenEvent {

    data class OnFullNameClick(val name : String) : RegistrationScreenEvent()

    data class OnEmailClick(val email : String) : RegistrationScreenEvent()

    data class OnPasswordClick(val password : String) : RegistrationScreenEvent()

    data class OnConfirmPasswordClick(val confirmPassword: String) : RegistrationScreenEvent()

    data object OnRegistrationButtonClick : RegistrationScreenEvent()


}