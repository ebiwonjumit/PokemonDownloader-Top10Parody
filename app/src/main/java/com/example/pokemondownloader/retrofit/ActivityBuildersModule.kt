package com.example.pokemondownloader.retrofit

import com.example.pokemondownloader.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}