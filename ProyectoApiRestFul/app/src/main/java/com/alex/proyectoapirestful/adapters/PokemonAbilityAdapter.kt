package com.alex.proyectoapirestful.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex.proyectoapirestful.databinding.AbilityPokemonBinding
import com.alex.proyectoapirestful.databinding.PokemonWithAbilityBinding
import com.alex.proyectoapirestful.models.ability.AbilityView

class PokemonAbilityAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val listAbility= mutableListOf<AbilityView>()

    fun addResults(data: List<AbilityView>){

        listAbility.addAll(data)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context);

        val pokemonWithAbilityBinding = PokemonWithAbilityBinding .inflate(layoutInflater, parent, false)
        return PokemonWhitAbilityViewHolder(pokemonWithAbilityBinding);

    }

    override fun getItemCount(): Int {

        return listAbility.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is PokemonWhitAbilityViewHolder){
            val result = listAbility[position]
            holder.onBind(result)


        }
    }
    inner class PokemonWhitAbilityViewHolder(private val cardPokemonWithAbilityBinding: PokemonWithAbilityBinding): RecyclerView.ViewHolder(cardPokemonWithAbilityBinding.root){

        fun onBind(abilityView: AbilityView){
            cardPokemonWithAbilityBinding.pokemonAbility= abilityView
            cardPokemonWithAbilityBinding.executePendingBindings()

        }

    }
}