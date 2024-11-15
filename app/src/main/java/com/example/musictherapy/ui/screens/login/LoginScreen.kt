package com.example.musictherapy.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.musictherapy.navigation.graph.AuthScreen
import com.example.musictherapy.navigation.graph.NavigationGraph
import com.example.musictherapy.ui.screens.registration.CustomInputOutlinedTextField
import com.example.musictherapy.ui.screens.registration.CustomPasswordOutlinedTextField

@Composable
fun LoginScreen(navHostController: NavHostController) {

    val viewModel: LoginScreenViewModel = hiltViewModel()

    val state by viewModel.state.collectAsStateWithLifecycle()

    val onEvent = viewModel::onEvent

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier,
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 57.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )
                Text(
                    text = "Please sign in to continue",
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.height(61.dp))
                CustomInputOutlinedTextField(
                    value = state.email,
                    onValueChange = {
                        onEvent(LoginScreenEvents.OnEmailClick(it))
                    },
                    placeHolder = "Email",
                    imageVector = Icons.Outlined.Email,
                    keyboardType = KeyboardType.Email
                )
                Spacer(modifier = Modifier.height(31.dp))
                CustomPasswordOutlinedTextField(
                    value = state.password,
                    onValueChange = {
                        onEvent(LoginScreenEvents.OnPasswordClick(it))
                    },
                    placeHolder = "Password"
                )
                Spacer(modifier = Modifier.height(5.dp))
                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.End),
                ) {
                    Text(text = "FORGET")
                }
                Spacer(modifier = Modifier.height(5.dp))
                Button(
                    onClick = {
                              navHostController.navigate(route = NavigationGraph.MAIN_SCREEN_PAGE){
                                  popUpTo(AuthScreen.LOGIN.route){
                                      inclusive = true
                                  }
                              }
                    },
                    modifier = Modifier
                        .align(Alignment.End),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "Login")
                }
            }
        }
        Spacer(modifier = Modifier.height(130.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Don't have an account? Signup",
                textAlign = TextAlign.Center
            )
        }
    }
}
