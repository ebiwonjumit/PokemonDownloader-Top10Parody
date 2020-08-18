package com.example.pokemondownloader.di

import com.example.pokemondownloader.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}