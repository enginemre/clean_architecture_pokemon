package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class GenerationIiDto(
    @SerializedName("crystal")
    val crystal: CrystalDto,
    @SerializedName("gold")
    val gold: GoldDto,
    @SerializedName("silver")
    val silver: SilverDto
)