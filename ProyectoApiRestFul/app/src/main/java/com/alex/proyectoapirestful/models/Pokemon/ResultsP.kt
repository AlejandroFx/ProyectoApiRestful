package com.alex.proyectoapirestful.models.pokemon

import com.google.gson.annotations.SerializedName

data class ResultsP (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)