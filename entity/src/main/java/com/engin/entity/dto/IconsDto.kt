package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class IconsDto(
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("front_female")
    val frontFemale: Any
)