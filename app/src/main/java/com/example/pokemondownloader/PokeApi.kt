package com.example.pokemondownloader

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("{pokemonId}")
    fun getPokemonById(@Path("pokemonId") pokemonId: String ) : Single<Pokemon>
}