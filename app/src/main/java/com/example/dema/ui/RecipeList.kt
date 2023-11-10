package com.example.dema.ui

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dema.R
import com.example.dema.models.Meal

@Composable
fun HomeScreen(
    recipeState: RecipeState,
    //onMealClick: (Meal) -> Unit,
) {
    when(recipeState){
        is RecipeState.Loading -> LoadingScreen()
        is RecipeState.Success -> RecipeList(recipeState.meals, /*onMealClick = onMealClick*/)
        is RecipeState.Error -> ErrorScreen()
    }
}

@Composable
fun RecipeList(
    recipes: List<Meal>,
    modifier: Modifier = Modifier,
    //onMealClick: (Meal) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(items = recipes, key = {it.idMeal}){
            RecipeItem(meal = it) //onMealClick = onMealClick
        }
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(stringResource(id = R.string.loading_failed))
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(stringResource(id = R.string.loading))
    }
}

