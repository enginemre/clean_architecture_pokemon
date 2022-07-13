package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class EmeraldDto(
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("front_shiny")
    val frontShiny: String
)