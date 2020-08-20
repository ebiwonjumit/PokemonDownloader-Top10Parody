package com.example.pokemondownloader.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.pokemondownloader.BaseApplication
import com.example.pokemondownloader.util.Constants
import com.example.pokemondownloader.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.poke_detail_layout.*
import java.lang.IllegalArgumentException
import javax.inject.Inject

class PokeDetailFragment : Fragment(R.layout.poke_detail_layout) {

        @Inject
        lateinit var picasso: Picasso

        @Inject
        lateinit var pokeDetailViewModel: PokeDetailViewModel

        val args: PokeDetailFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        (context.applicationContext as BaseApplication).appComponent.inject(this)
        super.onAttach(context)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = args.pokmonId
        picasso.load(Constants.IMAGE_URI +id+".png").fit().into(imageView)
        pokeDetailViewModel.nameLiveData.observe(viewLifecycleOwner,
            Observer{
            textView.text = it
        })
        pokeDetailViewModel.getPokemonName(id)
        super.onViewCreated(view, savedInstanceState)
    }
}