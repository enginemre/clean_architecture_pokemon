package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class TypeDto(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: TypeDtoX
)