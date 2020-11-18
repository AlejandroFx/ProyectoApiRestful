package com.alex.proyectoapirestful.models.Pokemon

import com.alex.proyectoapirestful.models.ability.Abilities
import com.alex.proyectoapirestful.models.type.Types
import com.google.gson.annotations.SerializedName

data class PokemonURL (

    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("name") val name : String,
    @SerializedName("abilities") val ability : Abilities,
    @SerializedName("types") val types: List<Types>
)