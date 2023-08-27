package com.example.pokedex.data

import com.example.pokedex.data.api.models.Pokedex
import retrofit2.Response

interface PokedexRepository {

    suspend fun getPokedex() : Response<Pokedex>
}