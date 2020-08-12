package com.example.pokemondownloader

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemondownloader.Constants.IMAGE_URI
import com.example.pokemondownloader.db.Pokemon
import com.example.pokemondownloader.ui.EMPTY_LIST
import com.squareup.picasso.Picasso

class PokemonViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_item,parent, false)){
   private var nameView: TextView? = null
   private var statView: TextView? = null
   private var imageView: ImageView? = null
   private var exp: Context


    init{
        nameView = itemView.findViewById(R.id.recyclerName)
        statView = itemView.findViewById(R.id.recyclerBaseStat)
        imageView = itemView.findViewById(R.id.recyclerImage)
        exp = itemView.context

    }

    fun bind(pokemon: Pokemon){
    Picasso.get().load(IMAGE_URI+pokemon.pokemonId+".png").into(imageView)
    nameView?.text = pokemon.name
    statView?.text = exp.getString(R.string.pokemon_exp, pokemon.baseExperience)
}

}



class PokeListAdapter(): RecyclerView.Adapter<PokemonViewHolder>() {

    private var list: List<Pokemon> = EMPTY_LIST

    fun setList(nlist: List<Pokemon>){
        list = nlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon: Pokemon = list[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int{
        return list.size
    }

}