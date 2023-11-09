package com.example.dema.data

import com.example.dema.models.Recipe
import com.example.dema.network.MealApiService
import retrofit2.Call

interface MealRepository {
    suspend fun getRecipeByCountryName(countryName: String): Recipe
}

class NetworkMealRepository(
    private val mealApiService: MealApiService
): MealRepository{
    override suspend fun getRecipeByCountryName(countryName: String): Recipe {
        return mealApiService.getRecipeByCountryName(countryName)
    }
}