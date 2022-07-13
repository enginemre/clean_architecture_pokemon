package com.engin.ui.state

import com.engin.entity.model.Pokemon


data class PokemonDetailState(
    val isLoading: Boolean = false,
    val error: String = "",
    val pokemon: Pokemon? = null
)
