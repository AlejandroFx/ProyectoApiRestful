package com.alex.proyectoapirestful.models.type

import com.alex.proyectoapirestful.models.pokemon.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonT (

    @SerializedName("slot") val slot : Int,
    @SerializedName("pokemon") val pokemon : Pokemon
)