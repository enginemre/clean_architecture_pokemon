package com.engin.entity.model


data class Pokemon(
    val id: Int,
    val height: Int?,
    val isDefault: Boolean,
    val locationAreaEncounters: String,
    val name: String,
    val abilities: List<Ability>,
    val imageUrl:String
    )
