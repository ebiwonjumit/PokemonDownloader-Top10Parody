package com.example.pokemondownloader.retrofit

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemondownloader.PokeViewModelProvider
import com.example.pokemondownloader.ui.PokeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokeViewModel::class)
    abstract fun bindSearchViewModel(viewModel: PokeViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: PokeViewModelProvider): ViewModelProvider.Factory
}