package com.alex.proyectoapirestful.models.pokemon

import com.alex.proyectoapirestful.models.ability.Abilities
import com.alex.proyectoapirestful.models.ability.Ability
import com.alex.proyectoapirestful.models.type.Results
import com.alex.proyectoapirestful.models.type.Types
import com.google.gson.annotations.SerializedName

data class PokemonURL (

    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("name") val name : String,
    @SerializedName("abilities") val abilities : List<Abilities>
    /*@SerializedName("types") val types: List<Results>*/
)