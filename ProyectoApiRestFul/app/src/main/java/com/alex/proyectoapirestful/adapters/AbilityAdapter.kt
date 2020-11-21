package com.alex.proyectoapirestful.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex.proyectoapirestful.databinding.AbilityPokemonBinding
import com.alex.proyectoapirestful.models.ability.AbilityView
import com.alex.proyectoapirestful.models.pokemon.PokemonView
import com.alex.proyectoapirestful.views.AbilityActivity

class AbilityAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val listAbility= mutableListOf<AbilityView>()


    fun addResults(data: List<AbilityView>){

        listAbility.addAll(data)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context);

        val abilityInfoBinding = AbilityPokemonBinding.inflate(layoutInflater, parent, false)
        return AbilityViewHolder(abilityInfoBinding);

    }

    override fun getItemCount(): Int {

        return listAbility.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is AbilityViewHolder){
            val result = listAbility[position]
            holder.onBind(result)


        }
    }
    inner class AbilityViewHolder(private val cardAbilityInfoBinding: AbilityPokemonBinding): RecyclerView.ViewHolder(cardAbilityInfoBinding.root){

        fun onBind(abilityView: AbilityView){
           cardAbilityInfoBinding.ability= abilityView
            cardAbilityInfoBinding.executePendingBindings()

        }

    }
}