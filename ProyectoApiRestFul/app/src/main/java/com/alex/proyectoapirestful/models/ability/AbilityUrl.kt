package com.alex.proyectoapirestful.models.ability

import com.alex.proyectoapirestful.models.type.PokemonT
import com.google.gson.annotations.SerializedName

data class  AbilityUrl(

    @SerializedName("pokemon") val pokemon: List<PokemonA>,
    @SerializedName("effect_entries") val effect: List<Effect>

)