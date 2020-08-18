package com.example.pokemondownloader.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemondownloader.util.Constants.IMAGE_URI
import com.example.pokemondownloader.R
import com.example.pokemondownloader.db.Pokemon
import com.squareup.picasso.Picasso
import javax.inject.Inject

class PokeListAdapter @Inject constructor(val picasso: Picasso): RecyclerView.Adapter<PokeListAdapter.PokemonViewHolder>() {

    private var list: List<Pokemon> =
        EMPTY_LIST
    var onItemClick: ((Pokemon) -> Unit)? = null

    fun setList(nlist: List<Pokemon>){
        list = nlist
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(
            inflater,
            parent,
            picasso
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon: Pokemon = list[position]
        holder.bind(pokemon)

    }

    override fun getItemCount(): Int{
        return list.size
    }

    inner class PokemonViewHolder(inflater: LayoutInflater, parent: ViewGroup, val picasso: Picasso): RecyclerView.ViewHolder(inflater.inflate(
        R.layout.recycler_item,parent, false)){
        private var  nameView: TextView = itemView.findViewById(R.id.recyclerName)
        private var statView: TextView = itemView.findViewById(R.id.recyclerBaseStat)
        private var imageView: ImageView = itemView.findViewById(R.id.recyclerImage)
        private var exp: Context = itemView.context

        init{
            itemView.setOnClickListener{
                onItemClick?.invoke(list[adapterPosition])
            }
        }

        fun bind(pokemon: Pokemon){
            picasso.load(IMAGE_URI+pokemon.pokemonId+".png").fit().into(imageView)
            nameView.text = pokemon.name
            statView.text = exp.getString(R.string.pokemon_exp, pokemon.baseExperience)
        }

    }
}