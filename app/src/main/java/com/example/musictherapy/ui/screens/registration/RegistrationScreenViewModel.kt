package com.example.musictherapy.ui.screens.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationScreenViewModel @Inject constructor(

) : ViewModel() {

    private val _state = MutableStateFlow(RegistrationScreenState())
    val state = _state.asStateFlow().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
        initialValue = RegistrationScreenState()
    )


    fun onEvent(event: RegistrationScreenEvent) {
        when (event) {
            is RegistrationScreenEvent.OnFullNameClick -> {
                viewModelScope.launch {
                    _state.update { registrationScreenState ->
                        registrationScreenState.copy(
                            fullName = event.name
                        )
                    }
                }
            }

            is RegistrationScreenEvent.OnEmailClick -> {
                viewModelScope.launch {
                    _state.update { registrationScreenState ->
                        registrationScreenState.copy(
                            email = event.email
                        )
                    }
                }
            }

            is RegistrationScreenEvent.OnPasswordClick -> {
                viewModelScope.launch {
                    _state.update { registrationScreenState ->
                        registrationScreenState.copy(
                            password = event.password
                        )
                    }
                }
            }

            is RegistrationScreenEvent.OnConfirmPasswordClick -> {
                viewModelScope.launch {
                    _state.update { registrationScreenState ->
                        registrationScreenState.copy(
                            confirmPassword = event.confirmPassword
                        )
                    }
                }
            }

            RegistrationScreenEvent.OnSignInButtonClick -> {
                viewModelScope.launch {
                    signIn()
                }

            }
        }
    }

    private fun signIn() {
        TODO("Not yet implemented")
    }
}