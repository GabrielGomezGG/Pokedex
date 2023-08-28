package com.example.pokedex.data.mappers

import com.example.pokedex.data.api.response.PokedexResults
import com.example.pokedex.data.models.Pokemon

fun PokedexResults.toPokemon() : Pokemon{
    return Pokemon(name, url)
}