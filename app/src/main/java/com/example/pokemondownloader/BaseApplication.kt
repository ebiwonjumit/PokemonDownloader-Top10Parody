package com.example.pokemondownloader

import android.app.Application
import android.content.Context
import com.example.pokemondownloader.retrofit.AppComponent
import com.example.pokemondownloader.retrofit.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication: Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }


}