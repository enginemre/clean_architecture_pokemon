package com.engin.data.remote

import com.engin.entity.dto.PokemonDto
import com.engin.entity.dto.PokemonListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *
 *
 * Retrofit Http requests interface
 *
 */
interface PokemonApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit:Int,
        @Query("offset") offset:Int,
    ): PokemonListDto


    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path ("name") name:String
    ):PokemonDto
}