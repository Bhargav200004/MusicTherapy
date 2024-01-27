package com.example.musictherapy.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictherapy.ui.screens.registration.RegistrationScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(

) : ViewModel() {

    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
        initialValue = LoginScreenState()
    )

    fun onEvent(event : LoginScreenEvents){
        when(event){
            is LoginScreenEvents.OnEmailClick -> {
                _state.update {loginScreenState->
                    loginScreenState.copy(
                        email = event.email
                    )
                }
            }
            is LoginScreenEvents.OnPasswordClick -> {
                _state.update {loginScreenState->
                    loginScreenState.copy(
                        password = event.password
                    )
                }
            }
        }
    }
}