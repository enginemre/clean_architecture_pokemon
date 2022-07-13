package com.engin.entity.model

import com.engin.entity.dto.AbilityDtoX

data class Ability(
    val ability: AbilityDtoX,
    val isHidden: Boolean,
    val slot: Int
)