package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class GenerationIiiDto(
    @SerializedName("emerald")
    val emerald: EmeraldDto,
    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreenDto,
    @SerializedName("ruby-sapphire")
    val rubySapphire: RubySapphireDto
)