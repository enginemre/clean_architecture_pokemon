package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class GenerationViDto(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphireDto,
    @SerializedName("x-y")
    val xY: XYDto
)