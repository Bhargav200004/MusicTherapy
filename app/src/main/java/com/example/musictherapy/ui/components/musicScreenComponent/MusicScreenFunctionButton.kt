package com.example.musictherapy.ui.components.musicScreenComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun MusicScreenFunctionButton(
    onClickShuffleButton: () -> Unit,
    onClickSkipPreviousButton: () -> Unit,
    onClickPauseButton: () -> Unit,
    onClickSkipNextButton: () -> Unit,
    onClickRepeatButton: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onClickShuffleButton) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                imageVector = Icons.Default.Shuffle,
                contentDescription = "shuffle Icon"
            )
        }
        IconButton(onClick = onClickSkipPreviousButton) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                imageVector = Icons.Default.SkipPrevious,
                contentDescription = "skip previous Icon"
            )
        }
        Box(
            modifier = Modifier
                .size(75.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(color = MaterialTheme.colorScheme.primary)
                .clickable { onClickPauseButton },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(50.dp),
                imageVector = Icons.Default.Pause,
                contentDescription = "Pause Icon"
            )
        }
        IconButton(onClick = onClickSkipNextButton) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                imageVector = Icons.Default.SkipNext,
                contentDescription = "skip Next Icon"
            )
        }
        IconButton(onClick = onClickRepeatButton) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                imageVector = Icons.Default.Repeat,
                contentDescription = "Repeat Icon"
            )
        }
    }
}