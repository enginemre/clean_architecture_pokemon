package com.engin.domain.usecase.get_pokemon

import com.engin.base.Resource
import com.engin.domain.repository.PokemonRepository
import javax.inject.Inject


class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(name:String) = repository.getPokemon(name)
}