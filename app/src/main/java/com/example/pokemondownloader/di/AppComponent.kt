package com.example.pokemondownloader.di

import android.app.Application
import com.example.pokemondownloader.BaseApplication
import com.example.pokemondownloader.ui.MainActivity
import com.example.pokemondownloader.ui.detail.PokeDetailFragment
import com.example.pokemondownloader.ui.list.PokeListFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {


    fun inject(activity: MainActivity)
    fun inject(fragment: PokeListFragment)
    fun inject(fragment: PokeDetailFragment)
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}