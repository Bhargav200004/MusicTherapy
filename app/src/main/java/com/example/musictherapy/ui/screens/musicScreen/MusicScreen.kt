package com.example.musictherapy.ui.screens.musicScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.musictherapy.R
import com.example.musictherapy.ui.components.musicScreenComponent.MusicScreenFunctionButton
import com.example.musictherapy.ui.components.musicScreenComponent.MusicScreenProgressIndicator
import com.example.musictherapy.ui.components.musicScreenComponent.MusicScreenTitleImage
import com.example.musictherapy.ui.components.musicScreenComponent.MusicScreenTopBar

@Composable
fun MusicScreen() {
    Scaffold(
        modifier = Modifier
            .padding(horizontal = 20.dp),
        topBar = {
            MusicScreenTopBar(
                title = "Ophelia by Steven",
                isLikeButtonSelected = false,
                onBackButtonClick = {},
                onLikeButtonClick = {}
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(13.dp))

            MusicScreenTitleImage(titleImage = R.drawable.demo)
            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Ophelia",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Steven Price",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W500)
            )

            Spacer(modifier = Modifier.height(41.dp))
            MusicScreenProgressIndicator(
                progress = 0.6f,
                initialTime = "0:00",
                finalTime = "3:15"
            )

            Spacer(modifier = Modifier.height(41.dp))

            MusicScreenFunctionButton(
                onClickShuffleButton = { /*TODO*/ },
                onClickSkipPreviousButton = { /*TODO*/ },
                onClickPauseButton = { /*TODO*/ },
                onClickSkipNextButton = { /*TODO*/ },
                onClickRepeatButton = {/*TODO*/ }
            )
        }
    }
}