package com.example.musictherapy.ui.components.homeScreenComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreenSearchBar(value: String, onValueChange : (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Listen The \nLatest Musics",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(12.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            maxLines = 1,
            shape = RoundedCornerShape(40.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            label = { Text(text = "Search Music") }
        )
    }
}