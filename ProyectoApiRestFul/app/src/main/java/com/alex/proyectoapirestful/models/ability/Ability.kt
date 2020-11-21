package com.alex.proyectoapirestful.models.ability

import com.google.gson.annotations.SerializedName

data class Ability(
    @SerializedName("results") val results : List<ResultsA>,
    @SerializedName("name") val name : String


)