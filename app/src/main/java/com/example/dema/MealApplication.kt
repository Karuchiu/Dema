package com.example.dema

import android.app.Application
import com.example.dema.data.AppContainer
import com.example.dema.data.DefaultAppContainer

class MealApplication: Application(){
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}