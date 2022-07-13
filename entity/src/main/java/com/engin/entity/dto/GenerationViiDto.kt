package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class GenerationViiDto(
    @SerializedName("icons")
    val icons: IconsDto,
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoonDto
)