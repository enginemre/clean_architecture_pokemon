package com.engin.domain.repository

import androidx.paging.PagingData
import com.engin.base.Resource
import com.engin.entity.model.Pokemon
import com.engin.entity.model.Result
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
     /**
      *
      * Getting pokemon's using Paging
      *
      */
     fun getPokemonList( ) :Flow<PagingData<Result>>

     /**
      *
      * Get single pokemon with name
      *
      */
     fun getPokemon(name:String): Flow<Resource<Pokemon>>
}