package com.example.pokemondownloader.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemondownloader.repository.PokeRepository
import javax.inject.Inject

class PokeListViewModelFactory @Inject constructor( val pokeRepository: PokeRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PokeListViewModel(pokeRepository) as T
    }

}