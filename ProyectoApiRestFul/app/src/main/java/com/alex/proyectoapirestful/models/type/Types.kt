package com.alex.proyectoapirestful.models.type

import com.google.gson.annotations.SerializedName

data class Types (

    @SerializedName("slot") val slot: Int,
    @SerializedName("type") val type: List<Type>

)