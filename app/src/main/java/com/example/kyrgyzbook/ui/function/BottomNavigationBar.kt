package com.example.kyrgyzbook.ui.function

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Triple("bookList", "Books", Icons.Filled.Check),
        Triple("favorites", "Favorites", Icons.Filled.Favorite),
        Triple("profile", "Profile", Icons.Filled.Person)
    )

    NavigationBar {
        items.forEach { (route, label, icon) ->
            NavigationBarItem(
                label = { Text(label) },
                selected = navController.currentDestination?.route == route,
                onClick = { navController.navigate(route) },
                icon = { Icon(icon, contentDescription = label) }
            )
        }
    }
}
