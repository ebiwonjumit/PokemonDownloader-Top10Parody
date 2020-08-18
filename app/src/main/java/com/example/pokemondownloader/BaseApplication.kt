package com.example.pokemondownloader

import android.app.Application
import com.example.pokemondownloader.di.AppComponent
import com.example.pokemondownloader.di.DaggerAppComponent


class BaseApplication: Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }


}