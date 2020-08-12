package com.example.pokemondownloader.ui

import android.util.Log
import androidx.lifecycle.*
import com.example.pokemondownloader.PokeRepository
import com.example.pokemondownloader.db.Pokemon
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

val EMPTY_LIST: List<Pokemon> = Collections.emptyList()


class PokeViewModel @Inject constructor(private val pokeRepository: PokeRepository) : ViewModel() {

    val randomPokeIds = List(10) { Random.nextInt(1, 807) }.sorted()



    private val _requestButtonState = MutableLiveData(true)
    val requestButtonState: LiveData<Boolean> = _requestButtonState
    val pokemonList = LiveDataReactiveStreams.fromPublisher(pokeRepository.getPokemon())

    fun loadPokemon() {
        pokeRepository.getPokemonById(randomPokeIds).doOnSubscribe {
            _requestButtonState.postValue(false)
        }.doOnEvent { t1, t2 -> _requestButtonState.postValue(true) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

}