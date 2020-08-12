package com.example.pokemondownloader.ui

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Adapter
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemondownloader.*
import com.example.pokemondownloader.db.Pokemon
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.poke_list_layout.*
import javax.inject.Inject

class PokeListFragment : Fragment(){

    @Inject lateinit var pokeViewModel: PokeViewModel


    override fun onAttach(context: Context) {
        (context.applicationContext as BaseApplication).appComponent.inject(this)
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view?.findNavController()?.navigate(R.id.action_PokeListFragment_to_PokeDetailFragment)
        return inflater.inflate(R.layout.poke_list_layout,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val pokemonAdapter = PokeListAdapter()

        recyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = pokemonAdapter
        }

        pokeViewModel.pokemonList.observe(viewLifecycleOwner,
            Observer{entries ->
                pokemonAdapter.setList(entries)
            })

        setHasOptionsMenu(true)

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
       inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.download_item -> {
                pokeViewModel.loadPokemon()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}