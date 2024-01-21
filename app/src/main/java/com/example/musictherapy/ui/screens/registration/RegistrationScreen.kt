package com.example.musictherapy.ui.screens.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationScreen() {
    var value by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Create Account",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontSize = 50.sp,
                fontFamily = FontFamily.SansSerif
            )
        )
        TextField(value = value, onValueChange = { value = it })
        TextField(value = value, onValueChange = { value = it })
        TextField(value = value, onValueChange = { value = it })
        TextField(value = value, onValueChange = { value = it })
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.End),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text( text = "SignUp")
        }
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