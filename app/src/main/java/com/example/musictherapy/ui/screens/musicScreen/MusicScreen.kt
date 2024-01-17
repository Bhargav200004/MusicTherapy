package com.example.musictherapy.ui.screens.musicScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MusicScreen() {
    Scaffold(
        topBar = { MusicScreenTopBar(
            title = "Ophelia by Steven",
            isLikeButtonSelected = false,
            onBackButtonClick = {},
            onLikeButtonClick = {}
        ) }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
        ) {

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicScreenTopBar(title: String, onBackButtonClick: () -> Unit, onLikeButtonClick: () -> Unit , isLikeButtonSelected : Boolean = false) {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        navigationIcon = {
            IconButton(onClick = onBackButtonClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "backButton Icon"
                )
            }
        },
        title = {
            Text(
                text = title
            )
        },
        actions = {
            IconButton(onClick = onLikeButtonClick) {
                Icon(
                    imageVector = if (isLikeButtonSelected) {
                        Icons.Default.Favorite
                    } else {
                        Icons.Outlined.FavoriteBorder
                    },
                    contentDescription = "Favourite Icon"
                )
            }
        }
    )
}
