package com.example.pokedex.ui

import com.example.pokedex.data.models.Pokemon

sealed class PokedexUiState {
    object Loading : PokedexUiState()

    object Error : PokedexUiState()

    class Success(val pokemonList : List<Pokemon>) : PokedexUiState()
}