package com.example.kyrgyzbook.ui.function

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kyrgyzbook.ui.model.Book

@Composable
fun BookListScreen(navController: NavController) {
    val books = listOf(
        Book("Жамиля", "Чынгыз Айтматов", "История о любви на фоне жизни в кыргызской деревне."),
        Book("Прощай, Гульсары!", "Чынгыз Айтматов", "Глубокая философская повесть о жизни и свободе."),
        Book("Белый пароход", "Чынгыз Айтматов", "Трогательная история мальчика и его мечты."),
        Book("И дольше века длится день", "Чынгыз Айтматов", "Роман о судьбе человека и борьбе с обстоятельствами.")
    )
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(books.size) { index ->
            val book = books[index]
            BookItem(book) {
                navController.navigate("bookDetails/${book.title}")
            }
        }
    }
}