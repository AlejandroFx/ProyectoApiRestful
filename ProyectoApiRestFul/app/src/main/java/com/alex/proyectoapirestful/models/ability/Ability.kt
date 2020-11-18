package com.alex.proyectoapirestful.models.ability

import com.google.gson.annotations.SerializedName

data class Ability(
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String

)