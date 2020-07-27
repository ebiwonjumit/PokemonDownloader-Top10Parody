package com.example.pokemondownloader

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val mDataset: List<PokemonDao>): RecyclerView.Adapter<RecyclerAdapter.PokemonViewHolder>() {

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

        fun bind(pokemonDao: PokemonDao){
            Picasso.get().load(imageUri+pokemonDao.id.toString() + ".png").into(mImageView)
            mNameView?.text = pokemonDao.name
            mStatView?.text = pokemonDao.baseStats.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon: PokemonDao = mDataset[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int = mDataset.size

}