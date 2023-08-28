package com.example.pokedex.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(pokedexViewModel: PokedexViewModel) {

    val response by pokedexViewModel.pokedex.collectAsState()

    when(response){
        PokedexUiState.Error -> TODO()
        PokedexUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        is PokedexUiState.Success -> {
            LazyColumn(){
                items((response as PokedexUiState.Success).pokemonList){
                    Text(text = it.name)
                }
            }
        }
    }

}