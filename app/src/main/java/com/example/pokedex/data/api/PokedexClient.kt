package com.example.pokedex.data.api

import com.example.pokedex.data.api.response.Pokedex
import retrofit2.Response
import retrofit2.http.GET

interface PokedexClient {

    @GET("pokemon/?limit=800")
    suspend fun get() : Response<Pokedex>

}

