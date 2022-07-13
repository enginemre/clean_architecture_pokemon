package com.engin.entity.dto


import com.engin.entity.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("abilities")
    val abilities: List<AbilityDto>,
    @SerializedName("base_experience")
    val baseExperience: Int,
    @SerializedName("forms")
    val forms: List<FormDto>,
    @SerializedName("game_indices")
    val gameIndices: List<GameIndiceDto>,
    @SerializedName("height")
    val height: Int,
    @SerializedName("held_items")
    val heldItems: List<Any>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_default")
    val isDefault: Boolean,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,
    @SerializedName("moves")
    val moves: List<MoveDto>,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("past_types")
    val pastTypes: List<Any>,
    @SerializedName("species")
    val species: SpeciesDto,
    @SerializedName("sprites")
    val sprites: SpritesDto,
    @SerializedName("stats")
    val stats: List<StatDto>,
    @SerializedName("types")
    val types: List<TypeDto>,
    @SerializedName("weight")
    val weight: Int
)

fun PokemonDto.toPokemon():Pokemon{
    val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
    return Pokemon(id, height, isDefault, locationAreaEncounters, name, abilities.map { it.toAbility() },imageUrl)
}