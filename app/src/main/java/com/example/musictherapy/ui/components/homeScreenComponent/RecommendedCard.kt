package com.example.musictherapy.ui.components.homeScreenComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musictherapy.R


@Composable
fun RecommendedCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .size(117.dp)
                .clip(shape = RoundedCornerShape(7.dp)),
            contentAlignment = Alignment.Center,
        ){
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.demo),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        Column(
            modifier = Modifier
                .height(117.dp)
                .fillMaxWidth(),
        ) {
            Spacer(modifier = Modifier.height(11.dp))
            Text(
                text = "Take care of you",
                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 24.sp)
            )
            Spacer(modifier = Modifier.height(4.dp),)
            Text(
                text = "Admina Thembi",
                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "114k / steams",
                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 18.sp)
            )
        }
    }
    Spacer(modifier = Modifier.height(17.dp))
}