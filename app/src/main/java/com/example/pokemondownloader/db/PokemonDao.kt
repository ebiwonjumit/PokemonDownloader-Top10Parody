package com.example.pokemondownloader.db

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe


/**
 * Data Access Object for Pokemon Class
 */
@Dao
interface PokemonDao {

    @Insert
    fun insert(pokemon: Pokemon)

    @Insert
    fun insert(pokemon: List<Pokemon>)

    @Update
    fun update(pokemon: Pokemon)

    @Delete
    fun delete(pokemon: Pokemon)

    @Delete
    fun deletePokemons(pokemons: List<Pokemon>)

    @Query("DELETE FROM pokemon_table")
    fun deleteAllPokemons(): Completable

    @Query("SELECT * FROM pokemon_table WHERE id = :pokemonId")
    fun getPokemonById(pokemonId: Int) : Maybe<Pokemon>

    @Query("SELECT * FROM pokemon_table ORDER BY id DESC")
    fun getAllPokemon(): Flowable<List<Pokemon>>

}