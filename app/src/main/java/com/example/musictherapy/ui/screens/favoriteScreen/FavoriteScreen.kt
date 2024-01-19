package com.example.musictherapy.ui.screens.favoriteScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.musictherapy.R
import com.example.musictherapy.ui.components.favoriteScreenComponent.FavouriteAlbumImage
import com.example.musictherapy.ui.components.favoriteScreenComponent.FavouriteMusicImage
import com.example.musictherapy.ui.components.favoriteScreenComponent.IntroductionCard

@Composable
fun FavoriteScreen() {
    Scaffold(
        topBar = { FavoriteScreenTopBar() }
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValue)
                .padding(horizontal = 20.dp)
        ) {

            IntroductionCard(
                name = "Sarwar Jahan",
                email = "sarwarmusic@gmail.com",
                membership = "Gold Member",
                description = "Love Music and I am not an Musician ."
            )

            Text(
                text = "Favourite Album",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(18.dp))
            LazyRow {
                items(15) {
                    FavouriteAlbumImage(image = R.drawable.demo )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Favourite Music",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(14.dp))
            LazyVerticalGrid(
                modifier = Modifier,
                columns = GridCells.Fixed(3)
            ) {
                items(20) {
                    FavouriteMusicImage(image = R.drawable.demo)
                }

            }

        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreenTopBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "FavoriteScreen Back Button"
            )
        },
        title = { /*TODO*/ }
    )
}
