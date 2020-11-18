package com.alex.proyectoapirestful.net.services

import com.alex.proyectoapirestful.models.Pokemon.Pokemon
import com.alex.proyectoapirestful.models.Pokemon.PokemonURL
import com.alex.proyectoapirestful.models.type.Types
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface PokemonService {

   @GET("pokemon")
    fun getPokemon() : Call<Pokemon>

    @GET("type")
    fun getTypeByName() : Call<Types>

    @GET
    fun getTypeByUrl(@Url url: String): retrofit2.Call<Types>

    @GET
    fun getPokemonByUrl(@Url url: String): retrofit2.Call<PokemonURL>
}