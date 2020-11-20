package com.alex.proyectoapirestful.net.services

import com.alex.proyectoapirestful.models.pokemon.Pokemon
import com.alex.proyectoapirestful.models.pokemon.PokemonURL
import com.alex.proyectoapirestful.models.type.Type
import com.alex.proyectoapirestful.models.type.Types
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonService {

   @GET("pokemon")
    fun getPokemon() : Call<Pokemon>

    @GET("type")
    fun getType() : Call<Type>

  @GET("type/{tipo}")
  fun getByType(@Path("tipo")tipo: String) : Call<Types>

    @GET
    fun getTypeByUrl(@Url url: String): retrofit2.Call<Types>

    @GET
    fun getPokemonByUrl(@Url url: String): retrofit2.Call<PokemonURL>

    @GET("pokemon/{nombre}")
    fun getByPokemon(@Path("nombre")tipo: String) : Call<PokemonURL>


}