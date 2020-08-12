package com.example.pokemondownloader

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.pokemondownloader.db.Pokemon
import com.example.pokemondownloader.db.PokemonDao
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokeRepository @Inject constructor(
    private val pokemonDao: PokemonDao,
    private val pokeApi: PokeApi,
    private val pokemonMapper: PokemonMapper
) {


    fun getPokemon() = pokemonDao.getAllPokemon()

    fun getPokemonById(pokemonId: Int): Single<Pokemon> {
        return pokemonDao.getPokemonById(pokemonId)
            .switchIfEmpty(pokeApi.getPokemonById(pokemonId.toString())
                .map { pokemonMapper.convert(it) }
                .doOnSuccess { pokemonDao.insert(it) })
    }


    fun getPokemonById(ids: List<Int>): Single<List<Pokemon>> {
        var pokemonRequests = ids.map { pokemonId ->
            pokemonDao.getPokemonById(pokemonId)
                .switchIfEmpty(pokeApi.getPokemonById(pokemonId.toString())
                    .map { pokemonMapper.convert(it) }
                )
        }
        return Single.merge(pokemonRequests).toList().doOnSuccess{ pokemonDao.insert(it)}
    }

}