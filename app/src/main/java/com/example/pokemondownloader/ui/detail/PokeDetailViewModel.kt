package com.example.pokemondownloader.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemondownloader.repository.PokeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PokeDetailViewModel @Inject constructor(private val pokeRepository: PokeRepository) : ViewModel() {

    private val disposable = CompositeDisposable()
    private val _nameLiveData = MutableLiveData<String>()
    val nameLiveData: LiveData<String> = _nameLiveData

    fun getPokemonName(id: Int){
       disposable.add(pokeRepository.getPokemonById(id).map { it.name }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _nameLiveData.value = it
            }, {}))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}