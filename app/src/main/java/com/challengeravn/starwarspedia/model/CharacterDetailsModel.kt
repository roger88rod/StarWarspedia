package com.challengeravn.starwarspedia.model

class CharacterDetailsModel(
    val name:String,
    val eyeColor: String,
    val hairColor: String,
    val skinColor: String,
    val birthYear: String,
    val vehicles:List<String>?
)