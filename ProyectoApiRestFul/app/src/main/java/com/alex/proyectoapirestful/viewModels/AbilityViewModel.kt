package com.alex.proyectoapirestful.viewModels

import android.app.Application
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.alex.proyectoapirestful.models.ability.AbilityView
import com.alex.proyectoapirestful.models.pokemon.PokemonView
import com.alex.proyectoapirestful.repositories.PokemonRepository
import kotlinx.coroutines.launch

class AbilityViewModel (application: Application) : AndroidViewModel(application){

    val pokemonRepository = PokemonRepository();
    val abilityListLiveData = MutableLiveData<List<AbilityView>>()
    var effectt :String="queso"

    fun getAbility(nameAbility: String?) {

        viewModelScope.launch {
            val ability = pokemonRepository.getByAbility(nameAbility)
            val effect: String =ability.effect[1].effect
            effectt=effect
            val listAbility = ability.pokemon.map { result ->

                val pokemonUrl=pokemonRepository.getPokemonByUrl(result.pokemon.url)
                val sprite=pokemonUrl.sprites.front_default

                AbilityView(
                    nameAbility,
                    effect,
                    sprite,
                    result.pokemon.name

                )

            }

            abilityListLiveData.postValue(listAbility)
        }
    }
}