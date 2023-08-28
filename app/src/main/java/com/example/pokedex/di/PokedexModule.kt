package com.example.pokedex.di

import com.example.pokedex.data.PokedexRepository
import com.example.pokedex.data.PokedexRepositoryImp
import com.example.pokedex.data.api.PokedexClient
import com.example.pokedex.domain.GetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokedexModule {

    @Provides
    @Singleton
    fun providePokedexRepositoy(pokedexClient: PokedexClient) : PokedexRepository{
        return PokedexRepositoryImp(pokedexClient)
    }

    @Provides
    @Singleton
    fun provideGetPokemonListUseCase(pokedexRepository: PokedexRepository) : GetPokemonListUseCase{
        return GetPokemonListUseCase(pokedexRepository)
    }

}