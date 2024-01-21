package com.example.musictherapy.ui.screens.login

import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    var value by remember { mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
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
                TextField(value = value, onValueChange = { value = it })
                Spacer(modifier = Modifier.height(31.dp))
                TextField(value = value, onValueChange = { value = it })
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
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.End),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text( text = "Login")
                }
            }
        }
        Spacer(modifier = Modifier.height(130.dp) )
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
