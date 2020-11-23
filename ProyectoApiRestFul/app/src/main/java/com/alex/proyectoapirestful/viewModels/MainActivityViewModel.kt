package com.alex.proyectoapirestful.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alex.proyectoapirestful.models.pokemon.PokemonView
import com.alex.proyectoapirestful.repositories.PokemonRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    val pokemonRepository = PokemonRepository();
    val pokemonListLiveData = MutableLiveData<List<PokemonView>>()
    var contPokemon: Int = 0


    fun getType(nameTipo: String) {

        viewModelScope.launch {
            val type = pokemonRepository.getByType(nameTipo)
            val listPokemon = type.pokemon.map { result ->
                val pokemonUrl=pokemonRepository.getPokemonByUrl(result.pokemon.url)
                val sprite=pokemonUrl.sprites.front_default
                val abilidad= pokemonUrl.abilities.firstOrNull()?.ability?.name
                //val pokemonByName=pokemonRepository.getByPokemon(result.pokemon.name)
                PokemonView(
                    sprite,
                    result.pokemon.name,
                    abilidad,
                    nameTipo
                )


            }


            pokemonListLiveData.postValue(listPokemon)
        }
    }
}





