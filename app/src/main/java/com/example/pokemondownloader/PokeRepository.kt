package com.example.pokemondownloader

import com.example.pokemondownloader.db.Pokemon
import com.example.pokemondownloader.db.PokemonDao

class PokeRepository private constructor(private val pokemonDao: PokemonDao){


        private val mPokemons = listOf(
            Pokemon("1", "Pikachu", 1),
            Pokemon("35", "Solomon", 2),
            Pokemon("50", "Turtwig", 3),
            Pokemon("899", "Persona", 4),
            Pokemon("74474873", "Ditto", 5)
    )

//    fun getPokemons() = pokemonDao.getPokemons()
//
//    fun getPokemon(pokemonId: String) = pokemonDao.getPokemon(pokemonId)
//
//    companion object{
//
//        @Volatile private var instance: PokeRepository? = null
//
//        fun getInstance(pokemonDao: PokemonDao){
//            instance ?: synchronized(this){
//                instance ?:PokeRepository(pokemonDao).also { instance = it}
//            }
//        }
//
//    }
}