package com.example.pokedex.data

import com.example.pokedex.data.api.PokedexClient
import com.example.pokedex.data.api.response.Pokedex
import com.example.pokedex.data.mappers.toPokemon
import com.example.pokedex.data.models.Pokemon
import javax.inject.Inject

class PokedexRepositoryImp @Inject constructor(
    private val pokedexClient: PokedexClient
) : PokedexRepository {

    override suspend fun getPokedex(): List<Pokemon> {
        try{
            return pokedexClient.get().body()!!.results.map { it.toPokemon() }
        }catch (e : Exception){
            throw e
        }

    }
}