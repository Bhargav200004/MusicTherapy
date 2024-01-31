package com.example.musictherapy.ui.screens.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musictherapy.navigation.graph.AuthScreen


@Composable
fun RegistrationScreen(navHostController: NavHostController) {


    val viewModel: RegistrationScreenViewModel = hiltViewModel()

    val state by viewModel.state.collectAsStateWithLifecycle()

    val onEvent = viewModel::onEvent

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "Create Account",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 50.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )
                CustomInputOutlinedTextField(
                    value = state.fullName,
                    onValueChange = {
                        onEvent(RegistrationScreenEvent.OnFullNameClick(it))
                    },
                    isSelected = state.isSelected,
                    placeHolder = "FULL NAME",
                    imageVector = Icons.Outlined.Person,
                    keyboardType = KeyboardType.Ascii
                )
                CustomInputOutlinedTextField(
                    value = state.email,
                    onValueChange = {
                        onEvent(RegistrationScreenEvent.OnEmailClick(it))
                    },
                    isSelected = state.isSelected,
                    placeHolder = "EMAIL",
                    imageVector = Icons.Outlined.Email,
                    keyboardType = KeyboardType.Email
                )
                CustomPasswordOutlinedTextField(
                    value = state.password,
                    onValueChange = {
                        onEvent(RegistrationScreenEvent.OnPasswordClick(it))
                    },
                    placeHolder = "PASSWORD"
                )
                CustomPasswordOutlinedTextField(
                    value = state.confirmPassword,
                    onValueChange = {
                        onEvent(RegistrationScreenEvent.OnConfirmPasswordClick(it))
                    },
                    placeHolder = "CONFIRM PASSWORD"
                )
                Spacer(modifier = Modifier.height(30.dp))
                ElevatedButton(
                    onClick = {
                        navHostController.navigate(route = AuthScreen.LOGIN.route){
                            popUpTo(route = AuthScreen.SIGNUP.route){
                                inclusive = true
                            }
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.End),
                    shape = RoundedCornerShape(8.dp),
                    elevation = ButtonDefaults.elevatedButtonElevation(),
                    colors = ButtonDefaults.elevatedButtonColors()
                ) {
                    Text(text = "SignUp")
                }
            }
        }


        Spacer(modifier = Modifier.fillMaxHeight(0.27f))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Already have a account? Sign in",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun CustomInputOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: String,
    imageVector: ImageVector,
    isSelected: Boolean = true,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .drawBehind {
                val boarderSize = 1.dp.toPx()
                drawLine(
                    color = Color.White,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = boarderSize
                )
            },
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = {
            if (isSelected) Text(text = placeHolder) else Text(text = "")
        },
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = "Password Icon"
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
        ),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}


@Composable
fun CustomPasswordOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: String
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .drawBehind {
                val boarderSize = 1.dp.toPx()
                drawLine(
                    color = Color.White,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = boarderSize
                )
            },
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text(text = placeHolder)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Password,
                contentDescription = "Password Icon"
            )
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Visibility, contentDescription = null)
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
        ),
        maxLines = 1
    )
}

