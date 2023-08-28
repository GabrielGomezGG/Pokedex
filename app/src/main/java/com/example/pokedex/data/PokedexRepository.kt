package com.example.pokedex.data

import com.example.pokedex.data.api.response.Pokedex
import com.example.pokedex.data.models.Pokemon
import retrofit2.Response

interface PokedexRepository {

    suspend fun getPokedex() : List<Pokemon>?
}