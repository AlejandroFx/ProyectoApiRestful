package com.alex.proyectoapirestful.repositories

import com.alex.proyectoapirestful.models.Pokemon.Pokemon
import com.alex.proyectoapirestful.models.Pokemon.PokemonURL
import com.alex.proyectoapirestful.net.RetroFitInstance
import com.alex.proyectoapirestful.models.type.Types
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class PokemonRepository {

    suspend fun  getPokemon(): Pokemon{
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
    }

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
    /*suspend fun  getTypeByName(name: String): Types {
        return suspendCoroutine {continuation ->
            RetroFitInstance.pokemonService.getTypeByName().enqueue(object : retrofit2.Callback<Types>{
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
    }*/


}