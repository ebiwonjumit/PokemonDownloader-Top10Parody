package com.example.pokemondownloader.network

import javax.inject.Inject


class PokemonMapper @Inject constructor() {

    fun convert(pokemon: Pokemon): com.example.pokemondownloader.db.Pokemon{
        return com.example.pokemondownloader.db.Pokemon(pokemon.pokemonId.toInt(), pokemon.name.capitalize(), pokemon.baseExperience)
    }
}