package com.example.pokemondownloader.retrofit

import android.app.Application
import com.example.pokemondownloader.BaseApplication
import com.example.pokemondownloader.MainActivity
import com.example.pokemondownloader.ui.PokeDetailFragment
import com.example.pokemondownloader.ui.PokeListFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
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