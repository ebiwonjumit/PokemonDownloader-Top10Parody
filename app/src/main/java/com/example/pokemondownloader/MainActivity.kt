package com.example.pokemondownloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private val mPokemons = listOf(
        PokemonDao("Pickachu",399,1),
        PokemonDao("Solomon",35,2),
        PokemonDao("Turtwig",0,3),
        PokemonDao("Persona",95,4),
        PokemonDao("Ditto",100090000,5)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        val viewAdapter: RecyclerView.Adapter<*> = RecyclerAdapter(mPokemons)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}