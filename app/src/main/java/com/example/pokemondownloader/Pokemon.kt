package com.example.pokemondownloader

import com.google.gson.annotations.SerializedName

//data class ApiResponse(@SerializedName("pokeFeed") val pokeFeed: PokeFeed)
//
//data class PokeFeed(@SerializedName("results") val results: List<Pokemon>)

data class Pokemon(
    @SerializedName("id")
    val pokemonId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("base_experience")
    val baseExperience: Int
)