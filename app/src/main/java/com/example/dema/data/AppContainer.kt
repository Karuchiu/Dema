package com.example.dema.data

import com.example.dema.network.MealApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val mealRepository: MealRepository
}

class DefaultAppContainer: AppContainer{
    private val BASE_URL =
        "https://www.themealdb.com/api/json/v1/1/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        /*
         Kotlin Serialization
         .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
         */
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: MealApiService by lazy {
        retrofit.create(MealApiService::class.java)
    }
    override val mealRepository: MealRepository by lazy {
        NetworkMealRepository(retrofitService)
    }
}