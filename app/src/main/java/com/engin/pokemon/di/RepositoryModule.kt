package com.engin.pokemon.di

import com.engin.data.repository.PokemonRepositoryImpl
import com.engin.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 *
 * Binding repository interfaces
 *
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    @Singleton
    abstract fun bindPokemonRepository(
        repositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository
}