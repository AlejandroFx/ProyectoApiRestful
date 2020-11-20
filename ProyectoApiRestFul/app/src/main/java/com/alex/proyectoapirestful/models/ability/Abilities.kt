package com.alex.proyectoapirestful.models.ability

import com.google.gson.annotations.SerializedName

data class Abilities(

    @SerializedName("is_hidden") val is_hidden : Boolean,
    @SerializedName("slot") val slot : Int,
    @SerializedName("ability") val ability : Ability


)