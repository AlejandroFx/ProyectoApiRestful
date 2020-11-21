package com.alex.proyectoapirestful.views

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alex.proyectoapirestful.R
import com.alex.proyectoapirestful.adapters.AbilityAdapter
import com.alex.proyectoapirestful.adapters.PokemonAbilityAdapter
import com.alex.proyectoapirestful.adapters.PokemonAdapter
import com.alex.proyectoapirestful.databinding.AbilityPokemonBinding
import com.alex.proyectoapirestful.models.ability.AbilityView
import com.alex.proyectoapirestful.models.pokemon.PokemonView
import com.alex.proyectoapirestful.viewModels.AbilityViewModel
import com.alex.proyectoapirestful.viewModels.MainActivityViewModel
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImageA(view: ImageView, url: String){
    Glide.with(view.context)
        .load(url)
        .into(view)
}

class AbilityActivity : AppCompatActivity(){
    private val abilityViewModel: AbilityViewModel by viewModels()
    val pokemonAdapter = PokemonAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding :AbilityPokemonBinding=DataBindingUtil.setContentView(this,R.layout.ability_pokemon)

        val Ability= intent.extras?.getString("Ability")
        val recyclerView= findViewById<RecyclerView>(R.id.pkWhitThisAbility)
        val pokemonAbility= PokemonAbilityAdapter()
        val abilityAdapter= AbilityAdapter()
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter= pokemonAbility


        abilityViewModel.abilityListLiveData .observe(this,
            Observer<List<AbilityView>> {

                pokemonAbility.addResults(it)
                pokemonAbility.notifyDataSetChanged()
            }
        )
        abilityViewModel.abilityListLiveData .observe(this,
            Observer<List<AbilityView>> {
                abilityAdapter.addResults(it)
                binding.textViewAbility.text=Ability
                abilityAdapter.notifyDataSetChanged()

            }
        )
       abilityViewModel.getAbility(Ability)
    }
}