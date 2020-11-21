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

    /*fun getPokemon(type: String) {

         viewModelScope.launch {
                val pokemon = pokemonRepository.getPokemon()
                val pokemonType=pokemonRepository.getPokemonByUrl(pokemon.results.first().url).types.first().type.name

             if(type==pokemonType){
                 val listPokemon = pokemon.results.map{ result ->
                     val pokemonURL = pokemonRepository.getPokemonByUrl(result.url)

                     PokemonView(
                         pokemonURL.sprites.front_default,
                         result.name,
                         pokemonURL.abilities.first().ability.name,
                         pokemonURL.types.first().type.name

                     )
                 }
                 pokemonListLiveData.postValue(listPokemon)
             }


            }
    }*/

    fun getType(nameTipo: String) {

        viewModelScope.launch {
            val type = pokemonRepository.getByType(nameTipo)
            val image : String=""
            val ability: String="keen-eye"
            val listPokemon = type.pokemon.map { result ->
               // val typeUrl = pokemonRepository.getTypeByUrl(result.url)
                //val pokemonUrl=pokemonRepository.getPokemonByUrl(result.pokemon.url)
                val pokemonByName=pokemonRepository.getByPokemon(result.pokemon.name)

                PokemonView(
                   // image,
                    //pokemonRepository.getPokemonByUrl(result.pokemon.url).sprites.front_default,
                    pokemonByName.sprites.front_default,
                    result.pokemon.name,
                    //ability,
                   pokemonByName.abilities.first().ability.name,
                    //pokemonRepository.getPokemonByUrl(result.pokemon.url).abilities.first().ability.name,
                    nameTipo
                )

            }
            pokemonListLiveData.postValue(listPokemon)
        }
    }
}




