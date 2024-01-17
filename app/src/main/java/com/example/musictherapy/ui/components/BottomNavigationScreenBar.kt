package com.example.musictherapy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.musictherapy.navigation.NavigationItem

@Composable
fun BottomNavigationScreenBar(
    item: List<NavigationItem>,
    currentRoute: String?,
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp,)
            .padding(top = 6.dp)
        ,
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .shadow(
                    ambientColor = Color.White,
                    spotColor = Color.White,
                    elevation = 8.dp,
                    shape = RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 40.dp
                    )
                ),
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
                        item.forEach { navigationItem ->
                            IconButton(
                                onClick = {
                                    if (currentRoute != navigationItem.route) {
                                        navController.graph.startDestinationRoute?.let {
                                            navController.popBackStack(it, true)
                                        }

                                        navController.navigate(navigationItem.route) {
                                            launchSingleTop = true
                                        }
                                    }
                                },
                                icon = navigationItem.icons,
                                isIconSelected = currentRoute != navigationItem.route,
                                contentDescription = navigationItem.contentDescription
                            )
                        }
                    }
                },
            )
        }
    }
}

@Composable
private fun IconButton(
    onClick: () -> Unit,
    icon: ImageVector,
    isIconSelected: Boolean,
    contentDescription: String
) {
    androidx.compose.material3.IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = if (!isIconSelected) MaterialTheme.colorScheme.primary else Color.LightGray
        )
    }
}
