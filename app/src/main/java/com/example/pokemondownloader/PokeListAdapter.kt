package com.example.pokemondownloader

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemondownloader.db.Pokemon
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val mDataset: List<Pokemon>): RecyclerView.Adapter<RecyclerAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_item, parent, false)){
        private var mNameView: TextView? = null
        private var mStatView: TextView? = null
        private var mImageView: ImageView? = null

        private var imageUri: String = "https://pokeres.bastionbot.org/images/pokemon/"

        init{
            mNameView = itemView.findViewById(R.id.recyclerName)
            mStatView = itemView.findViewById(R.id.recyclerBaseStat)
            mImageView = itemView.findViewById(R.id.recyclerImage)
        }

        fun bind(pokemon: Pokemon){
            Picasso.get().load(imageUri+pokemon.pokemonId.toString() + ".png").into(mImageView)
            mNameView?.text = pokemon.name
            mStatView?.text = pokemon.baseStats.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon: Pokemon = mDataset[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int = mDataset.size

}