package com.example.pokemondownloader.db

import androidx.lifecycle.LiveData
import androidx.room.*


/**
 * Data Access Object for Pokemon Class
 */
@Dao
interface PokemonDao {

    @Insert
    fun insert(pokemons: List<Pokemon>?)

    @Update
    fun update(pokemon: Pokemon?)

    @Delete
    fun delete(pokemon: Pokemon?)

    @Delete
    fun deletePokemons(pokemons: List<Pokemon>?)

//    @Query("DELETE FROM pokemon_table")
//    fun deleteAllPokemons(): Single<Int>

    @Query("SELECT * FROM pokemon_table ORDER BY id DESC")
    fun getAllPokemon(): LiveData<List<Pokemon>>


}