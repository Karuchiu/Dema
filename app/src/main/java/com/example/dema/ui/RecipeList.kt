package com.example.dema.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.dema.R
import com.example.dema.models.local.Dema

@Composable
fun RecipeList(
    onMealClick: (Dema) -> Unit
) {
    val demas = listOf(
        Dema("Wali", R.drawable.dema_1),
        Dema("Gishere", R.drawable.dema_2)
    )
    LazyColumn {
        items(demas){
            RecipeItem(
                dema = it,
                onMealClick = onMealClick
            )
        }
    }
}

