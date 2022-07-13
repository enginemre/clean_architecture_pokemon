package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class GenerationVDto(
    @SerializedName("black-white")
    val blackWhite: BlackWhiteDto
)