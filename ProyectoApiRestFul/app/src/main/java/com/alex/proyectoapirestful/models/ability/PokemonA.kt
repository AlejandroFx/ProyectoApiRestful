package com.alex.proyectoapirestful.models.ability

import com.alex.proyectoapirestful.models.pokemon.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonA (

    @SerializedName("slot") val slot : Int,
    @SerializedName("pokemon") val pokemon : Pokemon
    )