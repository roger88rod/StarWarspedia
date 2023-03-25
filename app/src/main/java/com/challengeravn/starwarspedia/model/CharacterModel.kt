package com.challengeravn.starwarspedia.model

data class CharacterModel(
    val name: String,
    val species: String,
    val homeworld: String,
    val episodes: List<String>
)