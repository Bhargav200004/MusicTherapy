package com.example.musictherapy.ui.components.favoriteScreenComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musictherapy.R

@Composable
fun IntroductionCard(name : String , email : String , membership : String , description : String = "Music Therapy") {
    Box(
        modifier = Modifier
            .height(191.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp , top = 10.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 12.dp),
                contentAlignment =  Alignment.TopStart
            ){
                Image(
                    modifier = Modifier
                        .size(100.dp),
                    painter = painterResource(id = R.drawable.demo),
                    contentDescription = null,
                )
            }

            Spacer(Modifier.width(18.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ){
                Text(
                    text = name ,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 21.sp, fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = email,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 16.sp )
                )
                Spacer(modifier = Modifier.height(11.dp))
                Text(
                    text = membership,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 16.sp )
                )
                Spacer(modifier = Modifier.height(13.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 16.sp )
                )
            }
        }
    }
}