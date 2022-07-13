package com.engin.entity.dto


import com.google.gson.annotations.SerializedName

data class VersionsDto(
    @SerializedName("generation-v")
    val generationV: GenerationVDto,
    @SerializedName("generation-vi")
    val generationVi: GenerationViDto,
    @SerializedName("generation-vii")
    val generationVii: GenerationViiDto,
    @SerializedName("generation-viii")
    val generationViii: GenerationViiiDto,
    @SerializedName("generation-i")
    val generationI: GenerationIDto,
    @SerializedName("generation-ii")
    val generationIi: GenerationIiDto,
    @SerializedName("generation-iii")
    val generationIii: GenerationIiiDto,
    @SerializedName("generation-iv")
    val generationIv: GenerationIvDto
)