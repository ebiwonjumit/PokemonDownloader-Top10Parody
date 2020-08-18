package com.example.pokemondownloader.repository

import com.example.pokemondownloader.network.PokeApi
import com.example.pokemondownloader.network.PokemonMapper
import com.example.pokemondownloader.db.Pokemon
import com.example.pokemondownloader.db.PokemonDao
import io.reactivex.Single
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
            .switchIfEmpty(pokeApi.getPokemonById(pokemonId.toString()).subscribeOn(Schedulers.io())
                .map { pokemonMapper.convert(it) }
                .doOnSuccess { pokemonDao.insert(it) })
    }


    fun getPokemonById(ids: List<Int>): Single<List<Pokemon>> {
        var pokemonRequests = ids.map { pokemonId ->
            pokemonDao.getPokemonById(pokemonId)
                .switchIfEmpty(pokeApi.getPokemonById(pokemonId.toString()).subscribeOn(Schedulers.io())
                    .map { pokemonMapper.convert(it) }
                )
        }
        return Single.merge(pokemonRequests).toList().doOnSuccess{ pokemonDao.insert(it)}
    }

}