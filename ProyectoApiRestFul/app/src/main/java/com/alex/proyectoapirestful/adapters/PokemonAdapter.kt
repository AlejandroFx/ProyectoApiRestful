package com.alex.proyectoapirestful.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex.proyectoapirestful.databinding.PokemonInfoBinding
import com.alex.proyectoapirestful.models.Pokemon.PokemonView
import com.alex.proyectoapirestful.views.AbilityActivity

class PokemonAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val listPokemon= mutableListOf<PokemonView>()


    fun addResults(data: List<PokemonView>){

        listPokemon.addAll(data)

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context);

        val pokemonInfoBinding = PokemonInfoBinding.inflate(layoutInflater, parent, false)
            return PokemonViewHolder(pokemonInfoBinding);

    }

    override fun getItemCount(): Int {

        return listPokemon.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is PokemonViewHolder){
            val result = listPokemon[position]
            holder.onBind(result)


        }
    }
    inner class PokemonViewHolder(private val cardPokemonInfoBinding: PokemonInfoBinding): RecyclerView.ViewHolder(cardPokemonInfoBinding.root){

        fun onBind(pokemonView: PokemonView){
            cardPokemonInfoBinding.pokemon = pokemonView
            cardPokemonInfoBinding.executePendingBindings()

            cardPokemonInfoBinding.textViewAbility.setOnClickListener { click ->
                val intent= Intent(this.itemView.context, AbilityActivity:: class.java)
                intent.putExtra("Ability", pokemonView.ability)

                this.itemView.context.startActivity(intent)
            }
        }

    }
}