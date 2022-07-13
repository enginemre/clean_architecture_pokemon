package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class VersionGroupDetailDto(
    @SerializedName("level_learned_at")
    val levelLearnedAt: Int,
    @SerializedName("move_learn_method")
    val moveLearnMethod: MoveLearnMethodDto,
    @SerializedName("version_group")
    val versionGroup: VersionGroupDto
)