package com.alex.proyectoapirestful.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alex.proyectoapirestful.models.Pokemon.PokemonView
import com.alex.proyectoapirestful.repositories.PokemonRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    val pokemonRepository = PokemonRepository();
    val pokemonListLiveData = MutableLiveData<List<PokemonView>>()

    fun getPokemon() {

         viewModelScope.launch {
                val pokemon = pokemonRepository.getPokemon()
                val listPokemon = pokemon.results.map{ result ->
                    val pokemonURL = pokemonRepository.getPokemonByUrl(result.url)
                    val tipo= pokemonURL.types.first().type.first().name
                        PokemonView(
                            pokemonURL.sprites.front_default,
                            result.name,
                            pokemonURL.ability.ability.first().name,
                            pokemonURL.types.first().type.first().name

                        )
             }
                    pokemonListLiveData.postValue(listPokemon)

            }
    }

    /*fun getType(nameTipo: String) {

            viewModelScope.launch {
                val type = pokemonRepository.getTypeByName(nameTipo)
                //val typeList = mutableListOf<TypeView>()
                val listPokemon = type.results.map{ result ->
                    TypeView(
                        result.name,
                        pokemonRepository.getPokemonByUrl(result.pokemon.first()).url

                    )
                    PokemonView(
                        pokemonRepository.getPokemonByUrl(result.pokemon.first()).sprites.front_default,
                        pokemonRepository.getPokemonByUrl(result.pokemon.first()).name,
                        pokemonRepository.getPokemonByUrl(result.pokemon.first()).ability.name,
                        result.name

                    )
                }
                pokemonListLiveData.postValue(listPokemon)

            }
        }*/

    }


