package com.engin.domain.usecase.get_pokemon_list

import com.engin.base.Resource
import com.engin.domain.repository.PokemonRepository
import com.engin.entity.model.PokemonList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke() = repository.getPokemonList()
}