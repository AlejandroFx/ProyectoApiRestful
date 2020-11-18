package com.alex.proyectoapirestful.net

import com.alex.proyectoapirestful.BASE_URL
import com.alex.proyectoapirestful.net.services.PokemonService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitInstance {
    companion object{
        @JvmStatic
        private val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        @JvmStatic
        public val pokemonService= retrofit.create(PokemonService::class.java)
    }

}