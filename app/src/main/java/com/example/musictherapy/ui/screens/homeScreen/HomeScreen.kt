package com.example.musictherapy.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musictherapy.R

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier
            .padding(horizontal = 20.dp),
        topBar = { TopHomeScreenBar() },
        bottomBar = { BottomHomeScreenBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
        ) {

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopHomeScreenBar() {
    TopAppBar(
        title = { Text(text = "") },
        actions = { 
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row (){
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = RoundedCornerShape(30.dp))
                            .background(Color.Red)
                            .padding(4.dp)
                    ){
                        Image(
                            modifier = Modifier
                                .fillMaxSize(),
                            painter = painterResource(id = R.drawable.baseline_person_3_24),
                            contentDescription = "Person"
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Gujjla Bhargav Sai Durga",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp
                            )
                        )
                        Text(text = "Gold Membership")
                    }
                }

                Icon(
                    imageVector = Icons.Outlined.NotificationsNone,
                    contentDescription = "Bell icon",
                )
            }
        }
    )
}

@Composable
fun BottomHomeScreenBar() {
    Box(
        modifier = Modifier
            .shadow(
                ambientColor = Color.White,
                spotColor = Color.White,
                elevation = 8.dp,
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp
                )
            )
            .clip(shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)),
        contentAlignment = Alignment.BottomStart,
    ) {
        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 85.dp, width = 1000.dp),
            actions = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 36.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Home"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.MusicNote,
                            contentDescription = "Music",
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "Heart"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = "Location"
                        )
                    }
                }
            },
        )
    }
}