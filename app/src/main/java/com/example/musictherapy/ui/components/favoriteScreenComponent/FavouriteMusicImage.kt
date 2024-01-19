package com.example.musictherapy.ui.components.favoriteScreenComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun FavouriteMusicImage(image : Int) {
    Box(
        modifier = Modifier
            .padding(6.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id =image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}