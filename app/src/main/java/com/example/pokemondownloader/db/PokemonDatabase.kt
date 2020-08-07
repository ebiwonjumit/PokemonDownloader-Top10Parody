package com.example.pokemondownloader.db


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Pokemon::class], version = 3)
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun PokemonDao() : PokemonDao
}