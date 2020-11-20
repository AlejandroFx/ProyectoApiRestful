package com.alex.proyectoapirestful.models.type

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)