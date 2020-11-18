package com.alex.proyectoapirestful.models.Pokemon

import com.google.gson.annotations.SerializedName

data class Pokemon(

    /*@SerializedName("sprites") val sprites: Sprites,
    @SerializedName("name") val name : String,
    @SerializedName("ability") val ability : Ability,
    @SerializedName("type") val type: List<String>*/
    @SerializedName("results") val results: List<Results>



)