package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class MoveDto(
    @SerializedName("move")
    val move: MoveDtoX,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetailDto>
)