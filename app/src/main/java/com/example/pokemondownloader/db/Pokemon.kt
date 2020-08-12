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

// A comparator to compare last names of Name
class SortByNameComparator: Comparator<Pokemon>{
    override fun compare(o1: Pokemon?, o2: Pokemon?): Int {
        if (o1 == null || o2 == null)
            return 0
        return o1.name.compareTo(o2.name)
    }
}