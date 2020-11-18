package com.alex.proyectoapirestful.models.Pokemon

import com.google.gson.annotations.SerializedName

data class Results (
    @SerializedName("name") val name: String,
    @SerializedName("type") val url: String
)