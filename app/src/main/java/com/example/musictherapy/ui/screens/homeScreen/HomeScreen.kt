package com.example.musictherapy.ui.screens.homeScreen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musictherapy.ui.components.homeScreenComponent.HomeScreenSearchBar
import com.example.musictherapy.ui.components.homeScreenComponent.RecommendedCard
import com.example.musictherapy.ui.components.homeScreenComponent.TopHomeScreenBar
import com.example.musictherapy.ui.components.homeScreenComponent.recentlyPlayed

@Composable
fun HomeScreen() {

    var value by remember { mutableStateOf("")}

    Scaffold(
        modifier = Modifier
            .padding(horizontal = 20.dp),
        topBar = { TopHomeScreenBar() },
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
        ) {
            item {
                HomeScreenSearchBar(value , onValueChange = { value  = it })
            }
            item {
                Spacer(modifier = Modifier.height(44.dp))
            }
            recentlyPlayed()
            item { 
                Spacer(modifier = Modifier.height(28.dp))
                Text(text = "Recommended For You" , style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 23.sp
                ))
                Spacer(modifier = Modifier.height(18.dp))
            }
            items(5){
                RecommendedCard()
            }
        }
    }
}




