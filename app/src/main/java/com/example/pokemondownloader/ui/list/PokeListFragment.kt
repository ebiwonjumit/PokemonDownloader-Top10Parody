package com.example.pokemondownloader.ui.list

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemondownloader.*
import kotlinx.android.synthetic.main.poke_list_layout.*
import javax.inject.Inject

class PokeListFragment : Fragment(R.layout.poke_list_layout) {


    @Inject
    lateinit var injectedAdapter: PokeListAdapter
    @Inject
    lateinit var pokeListViewModelFactory: PokeListViewModelFactory

    val  pokeListViewModel by viewModels<PokeListViewModel> {pokeListViewModelFactory }


    override fun onAttach(context: Context) {
        (context.applicationContext as BaseApplication).appComponent.inject(this)
        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = injectedAdapter
        }

        pokeListViewModel.pokemonList.observe(viewLifecycleOwner,
            Observer { entries ->
                injectedAdapter.setList(entries)
                injectedAdapter.onItemClick = {
                    onItemClick(it.pokemonId)
                }
            })

        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.download_item -> {
                pokeListViewModel.loadPokemon()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onItemClick(id:Int){
        val action = PokeListFragmentDirections.actionPokeListFragmentToPokeDetailFragment(id)
        view?.findNavController()?.navigate(action)
    }


}