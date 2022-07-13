package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class GameIndiceDto(
    @SerializedName("game_index")
    val gameIndex: Int,
    @SerializedName("version")
    val version: VersionDto
)