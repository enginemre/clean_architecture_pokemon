package com.engin.entity.dto


import com.engin.entity.model.Ability
import com.google.gson.annotations.SerializedName

data class AbilityDto(
    @SerializedName("ability")
    val ability: AbilityDtoX,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    @SerializedName("slot")
    val slot: Int
)
fun AbilityDto.toAbility():Ability{
    return Ability(ability, isHidden, slot)
}