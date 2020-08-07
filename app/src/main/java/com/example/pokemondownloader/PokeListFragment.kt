package com.example.pokemondownloader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.recycler_item.*

class PokeListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view?.findNavController()?.navigate(R.id.action_PokeListFragment_to_PokeDetailFragment)
        return inflater.inflate(R.layout.poke_list_layout,container,false)
    }


}