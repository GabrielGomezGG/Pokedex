package com.example.pokedex.data

import com.example.pokedex.data.api.PokedexClient
import com.example.pokedex.data.api.models.Pokedex
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PokedexRepositoryImp @Inject constructor(
    private val pokedexClient: PokedexClient
) : PokedexRepository {

    override suspend fun getPokedex(): Response<Pokedex> {
        return withContext(Dispatchers.IO) {
            pokedexClient.get()
        }
    }
}