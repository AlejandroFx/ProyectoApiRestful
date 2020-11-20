package com.alex.proyectoapirestful.models.type

import com.alex.proyectoapirestful.models.pokemon.Pokemon
import com.alex.proyectoapirestful.models.pokemon.ResultsP
import com.google.gson.annotations.SerializedName

data class Types (

    @SerializedName("pokemon") val pokemon: List<PokemonT>
    /*@SerializedName("type") val type: Type*/


)