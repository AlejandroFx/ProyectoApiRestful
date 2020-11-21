package com.alex.proyectoapirestful.net.services

import com.alex.proyectoapirestful.models.ability.Ability
import com.alex.proyectoapirestful.models.ability.AbilityUrl
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


  @GET("type/{tipo}")
  fun getByType(@Path("tipo")tipo: String) : Call<Types>

    @GET("ability/{name}")
    fun getByAbility(@Path("name")tipo: String?) : Call<AbilityUrl>

    @GET("pokemon/{nombre}")
    fun getByPokemon(@Path("nombre")nombre: String) : Call<PokemonURL>

    @GET
    fun getTypeByUrl(@Url url: String): retrofit2.Call<Types>

    @GET
    fun getPokemonByUrl(@Url url: String): retrofit2.Call<PokemonURL>




}