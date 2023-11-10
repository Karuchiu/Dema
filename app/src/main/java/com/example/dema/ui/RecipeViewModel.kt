package com.example.dema.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dema.MealApplication
import com.example.dema.data.MealRepository
import com.example.dema.models.Meal
import kotlinx.coroutines.launch
import retrofit2.*

sealed interface RecipeState {
    object Loading : RecipeState
    data class Success(val meals: List<Meal>) : RecipeState
    data class Error(val message: String) : RecipeState
}

/**
 * A Difference when I use "sealed class instead of sealed interface"
 */
/*sealed class RecipeState {
    object Loading : RecipeState()
    data class Success(val meals: List<Meal>) : RecipeState()
    data class Error(val message: String) : RecipeState()
}*/

class RecipeViewModel(
    private val mealRepository: MealRepository
) : ViewModel() {
    var recipeState: RecipeState by mutableStateOf(RecipeState.Loading)
        private set //Alternative option(use MutableStateFlow from kotlinx.coroutines"

    init {
        getMealsByCountryName("Indian")
    }

    private fun getMealsByCountryName(countryName: String) =
        viewModelScope.launch {
            try {
                recipeState =
                    RecipeState.Success(mealRepository.getRecipeByCountryName(countryName).meals)
            } catch (e: Exception) {
                RecipeState.Error(e.message ?: "An error occurred")
            }
        }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MealApplication)
                val mealRepository = application.container.mealRepository
                RecipeViewModel(mealRepository = mealRepository)
            }
        }
    }
}