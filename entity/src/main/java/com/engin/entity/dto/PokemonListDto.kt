package com.engin.entity.dto


import com.engin.entity.model.PokemonList
import com.engin.entity.model.Result
import com.google.gson.annotations.SerializedName

data class PokemonListDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<ResultDto>
)
fun PokemonListDto.toPokemonList(): PokemonList {

    return PokemonList(count,next,previous ,results.map { it.toResult() })
}