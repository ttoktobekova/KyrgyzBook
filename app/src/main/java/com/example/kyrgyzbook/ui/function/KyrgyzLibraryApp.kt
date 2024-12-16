package com.example.kyrgyzbook.ui.function

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun KyrgyzLibraryApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "bookList",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("bookList") { BookListScreen(navController) }
            composable("bookDetails/{bookTitle}") { backStackEntry ->
                val bookTitle = backStackEntry.arguments?.getString("bookTitle")
                BookDetailScreen(bookTitle)
            }
            composable("favorites") { FavoritesScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}
