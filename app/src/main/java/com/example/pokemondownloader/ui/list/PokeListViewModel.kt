package com.example.pokemondownloader.ui.list


import androidx.lifecycle.*
import com.example.pokemondownloader.repository.PokeRepository
import com.example.pokemondownloader.db.Pokemon
import com.example.pokemondownloader.db.SortByNameComparator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

val EMPTY_LIST: List<Pokemon> = Collections.emptyList()


class PokeListViewModel @Inject constructor(private val pokeRepository: PokeRepository) : ViewModel() {

    fun randomPokeIds() = List(10) { Random.nextInt(1, 807) }



    private val _requestButtonState = MutableLiveData(true)
    val requestButtonState: LiveData<Boolean> = _requestButtonState
    val pokemonList = LiveDataReactiveStreams.fromPublisher(pokeRepository.getPokemon().map {
        Collections.sort(it,SortByNameComparator())
        it
    })

    fun loadPokemon() {
        pokeRepository.getPokemonById(randomPokeIds()).doOnSubscribe {
            _requestButtonState.postValue(false)
        }.doOnEvent { _, _ -> _requestButtonState.postValue(true) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe()
    }


}