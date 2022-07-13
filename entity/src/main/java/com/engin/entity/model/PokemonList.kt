package com.engin.entity.model

import com.engin.entity.dto.ResultDto
import com.google.gson.annotations.SerializedName

data class PokemonList(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Result>
) {
}