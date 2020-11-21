package com.alex.proyectoapirestful.repositories

import com.alex.proyectoapirestful.models.ability.Ability
import com.alex.proyectoapirestful.models.ability.AbilityUrl
import com.alex.proyectoapirestful.models.ability.ResultsA
import com.alex.proyectoapirestful.models.pokemon.Pokemon
import com.alex.proyectoapirestful.models.pokemon.PokemonURL
import com.alex.proyectoapirestful.models.type.Type
import com.alex.proyectoapirestful.models.type.Types
import com.alex.proyectoapirestful.net.RetroFitInstance
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class PokemonRepository {

    /*suspend fun  getPokemon(): Pokemon{
        return suspendCoroutine {continuation ->
            RetroFitInstance.pokemonService.getPokemon().enqueue(object : retrofit2.Callback<Pokemon>{
                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(
                    call: Call<Pokemon>,
                    response: Response<Pokemon>
                ) {
                    if(response.isSuccessful){
                        continuation.resume(response.body()!!)
                    }else{
                        continuation.resumeWithException(Exception("La respuesta del Pokemon no fue exitosa"))

                    }
                }


            })

        }
    }*/

    suspend fun getPokemonByUrl(url: String) = suspendCoroutine<PokemonURL> {
        RetroFitInstance.pokemonService.getPokemonByUrl(url).enqueue(
            object: retrofit2.Callback<PokemonURL> {
                override fun onResponse(call: Call<PokemonURL>, response: Response<PokemonURL>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<PokemonURL>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }

    /*suspend fun  getType(): Type {
        return suspendCoroutine {continuation ->
            RetroFitInstance.pokemonService.getType().enqueue(object : retrofit2.Callback<Type>{
                override fun onFailure(call: Call<Type>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(
                    call: Call<Type>,
                    response: Response<Type>
                ) {
                    if(response.isSuccessful){
                        continuation.resume(response.body()!!)
                    }else{
                        continuation.resumeWithException(Exception("La respuesta del tipo no fue exitosa"))

                    }
                }


            })

        }
    }*/

    suspend fun  getByType(tipo: String): Types {
        return suspendCoroutine {continuation ->
            RetroFitInstance.pokemonService.getByType(tipo).enqueue(object : retrofit2.Callback<Types>{
                override fun onFailure(call: Call<Types>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(
                    call: Call<Types>,
                    response: Response<Types>
                ) {
                    if(response.isSuccessful){
                        continuation.resume(response.body()!!)
                    }else{
                        continuation.resumeWithException(Exception("La respuesta del tipo no fue exitosa"))

                    }
                }


            })

        }
    }

    suspend fun  getByAbility(name: String?): AbilityUrl {
        return suspendCoroutine {continuation ->
            RetroFitInstance.pokemonService.getByAbility(name).enqueue(object : retrofit2.Callback<AbilityUrl>{
                override fun onFailure(call: Call<AbilityUrl>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(
                    call: Call<AbilityUrl>,
                    response: Response<AbilityUrl>
                ) {
                    if(response.isSuccessful){
                        continuation.resume(response.body()!!)
                    }else{
                        continuation.resumeWithException(Exception("La respuesta del tipo no fue exitosa"))

                    }
                }


            })

        }
    }

    suspend fun  getByPokemon(name: String) : PokemonURL {
        return suspendCoroutine {continuation ->
            RetroFitInstance.pokemonService.getByPokemon(name).enqueue(object : retrofit2.Callback<PokemonURL>{
                override fun onFailure(call: Call<PokemonURL>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(
                    call: Call<PokemonURL>,
                    response: Response<PokemonURL>
                ) {
                    if(response.isSuccessful){
                        continuation.resume(response.body()!!)
                    }else{
                        continuation.resumeWithException(Exception("La respuesta del pokemon no fue exitosa"))

                    }
                }


            })

        }
    }

    suspend fun getTypeByUrl(url: String) = suspendCoroutine<Types> {
        RetroFitInstance.pokemonService.getTypeByUrl(url).enqueue(
            object: retrofit2.Callback<Types> {
                override fun onResponse(call: Call<Types>, response: Response<Types>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<Types>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }


}