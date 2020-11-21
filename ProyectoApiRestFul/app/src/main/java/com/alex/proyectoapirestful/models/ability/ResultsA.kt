package com.alex.proyectoapirestful.models.ability

import com.google.gson.annotations.SerializedName

data class ResultsA (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

