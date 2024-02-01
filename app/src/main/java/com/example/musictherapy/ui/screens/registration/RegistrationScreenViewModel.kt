package com.example.musictherapy.ui.screens.registration

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictherapy.data.Resources
import com.example.musictherapy.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationScreenViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(RegistrationScreenState())
    val state = _state.asStateFlow().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
        initialValue = RegistrationScreenState()
    )

    private val _loginFlow = MutableStateFlow<Resources<FirebaseUser>?>(null)
    val loginFlow : StateFlow<Resources<FirebaseUser>?> = _loginFlow


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

            }
        }
    }

    private fun signUp() {
        viewModelScope.launch {
            val name = state.value.fullName
            val email = state.value.email
            val password = state.value.password
            try {
                val result = authRepository.signUpWithEmailAndPassword(
                    name = name,
                    email = email,
                    password = password
                )
                _loginFlow.value = result
            }
            catch (e : Exception){
                Log.e("error-signUp","${e.message}")
            }

        }
    }
}