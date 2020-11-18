package com.alex.proyectoapirestful.models.ability

import com.alex.proyectoapirestful.models.Pokemon.Pokemon
import com.google.gson.annotations.SerializedName

data class Abilities(
    @SerializedName("ability") val ability : List<Ability>,
    @SerializedName("is_hidden") val is_hidden : Boolean,
    @SerializedName("slot") val slot : Int


)