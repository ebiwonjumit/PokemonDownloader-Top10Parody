package com.example.pokemondownloader.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val pokemonId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name="base_experience")
    val baseExperience: Int) {
}