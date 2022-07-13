package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class MoveLearnMethodDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)