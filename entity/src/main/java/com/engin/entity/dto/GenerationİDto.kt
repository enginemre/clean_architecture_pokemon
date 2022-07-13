package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class GenerationIDto(
    @SerializedName("red-blue")
    val redBlue: RedBlueDto,
    @SerializedName("yellow")
    val yellow: YellowDto
)