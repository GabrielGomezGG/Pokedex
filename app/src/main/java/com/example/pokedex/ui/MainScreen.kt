package com.example.pokedex.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokedex.R
import com.example.pokedex.data.models.Pokemon
import com.example.pokedex.utils.ImageBuilder

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
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp)
            ){
                items((response as PokedexUiState.Success).pokemonList){
                    PokemonCard(pokemon = it)
                }
            }
        }
    }
}

@Composable
fun PokemonCard(pokemon : Pokemon) {
    Card(
        modifier = Modifier.padding(8.dp),
    ) {
        Column(Modifier.padding(8.dp)) {
            Column {
                AsyncImage(
                    model = ImageBuilder.buildPokemonImageByUrl(pokemon.url),
                            contentDescription = pokemon.name,
                    placeholder = painterResource(id = R.drawable.pokeball),
                    modifier = Modifier.size(128.dp)
                )
                Text(
                    text = pokemon.name,
                    Modifier
                        .fillMaxWidth(),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}