package com.alex.proyectoapirestful.models.ability

import com.google.gson.annotations.SerializedName

data class Effect(
    @SerializedName("effect") val effect : String
)