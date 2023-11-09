package com.example.dema.network

import com.example.dema.models.Recipe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiService {

    @GET("filter.php?")
    fun getRecipeByCountryName(@Query("a") countryName: String): Call<Recipe>
}